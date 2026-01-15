package com.liubz.androidtea.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String TAG = "CrashHandler";
    private static final String UPLOAD_URL = "https://your-server.com/api/crash/report"; 
    private static final String CRASH_DIR_NAME = "crash_logs";

    private Thread.UncaughtExceptionHandler mDefaultHandler;
    private static final CrashHandler INSTANCE = new CrashHandler();
    private Context mContext;
    private final Map<String, String> mDeviceInfo = new HashMap<>();
    
    private final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .build();

    private CrashHandler() {}

    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    public void init(Context context) {
        mContext = context.getApplicationContext();
        mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);

        // App 启动时检查并上传上次崩溃留下的日志
        checkAndUploadReports();
    }

    @Override
    public void uncaughtException(@NonNull Thread t, @NonNull Throwable e) {
        if (!handleException(e) && mDefaultHandler != null) {
            mDefaultHandler.uncaughtException(t, e);
        } else {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Log.e(TAG, "error : ", ex);
            }
            android.os.Process.killProcess(android.os.Process.myPid());
            System.exit(1);
        }
    }

    private boolean handleException(Throwable e) {
        if (e == null) return false;

        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                Toast.makeText(mContext, "程序出现异常, 正在收集日志...", Toast.LENGTH_LONG).show();
                Looper.loop();
            }
        }.start();

        collectDeviceInfo(mContext);
        String crashInfo = getCrashInfo(e);

        // 1. 立即同步保存到本地，并获取文件对象
        File crashFile = saveCrashToFile(crashInfo);

        // 2. 尝试同步上传，并传入文件对象以便成功后执行删除
        if (crashFile != null) {
            uploadExceptionToServerSync(crashInfo, crashFile);
        }

        return true;
    }

    private File saveCrashToFile(String crashInfo) {
        try {
            long timestamp = System.currentTimeMillis();
            String fileName = "crash-" + timestamp + ".log";
            File dir = new File(mContext.getFilesDir(), CRASH_DIR_NAME);
            if (!dir.exists()) dir.mkdirs();
            
            File file = new File(dir, fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(crashInfo.getBytes());
            fos.close();
            return file;
        } catch (Exception e) {
            Log.e(TAG, "Failed to save crash log to file", e);
            return null;
        }
    }

    private void uploadExceptionToServerSync(String crashLog, File file) {
        try {
            String json = "{\"crashLog\":\"" + crashLog.replace("\"", "\\\"").replace("\n", "\\n") + "\"}";
            RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
            Request request = new Request.Builder().url(UPLOAD_URL).post(body).build();

            // 同步执行
            try (Response response = mOkHttpClient.newCall(request).execute()) {
                if (response.isSuccessful()) {
                    Log.i(TAG, "Crash report uploaded successfully in real-time. Deleting local backup.");
                    // 修正点：上传成功后，立即删除本地备份文件，避免下次启动重复上传
                    file.delete();
                }
            }
        } catch (Exception e) {
            Log.e(TAG, "Real-time upload failed, file remains on disk for next launch retry", e);
        }
    }

    private void checkAndUploadReports() {
        new Thread(() -> {
            File dir = new File(mContext.getFilesDir(), CRASH_DIR_NAME);
            if (!dir.exists()) return;

            File[] files = dir.listFiles();
            if (files == null) return;

            for (File file : files) {
                try {
                    String content = readFileContent(file);
                    if (uploadSync(content)) {
                        file.delete(); // 上传成功则清除
                        Log.i(TAG, "Historical crash report uploaded and deleted: " + file.getName());
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Failed to upload historical report", e);
                }
            }
        }).start();
    }

    private boolean uploadSync(String log) throws Exception {
        String json = "{\"crashLog\":\"" + log.replace("\"", "\\\"").replace("\n", "\\n") + "\"}";
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json; charset=utf-8"));
        Request request = new Request.Builder().url(UPLOAD_URL).post(body).build();
        try (Response response = mOkHttpClient.newCall(request).execute()) {
            return response.isSuccessful();
        }
    }

    private String readFileContent(File file) throws Exception {
        java.util.Scanner scanner = new java.util.Scanner(file).useDelimiter("\\A");
        return scanner.hasNext() ? scanner.next() : "";
    }

    private void collectDeviceInfo(Context ctx) {
        try {
            PackageManager pm = ctx.getPackageManager();
            PackageInfo pi = pm.getPackageInfo(ctx.getPackageName(), 0);
            if (pi != null) {
                mDeviceInfo.put("versionName", pi.versionName == null ? "null" : pi.versionName);
                mDeviceInfo.put("versionCode", String.valueOf(pi.versionCode));
            }
        } catch (Exception e) {
            Log.e(TAG, "Error collecting package info", e);
        }
        for (Field field : Build.class.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(null);
                mDeviceInfo.put(field.getName(), value != null ? value.toString() : "null");
            } catch (Exception e) {
                Log.e(TAG, "Error collecting device info", e);
            }
        }
    }

    private String getCrashInfo(Throwable e) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : mDeviceInfo.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
        }
        Writer writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        e.printStackTrace(printWriter);
        printWriter.close();
        sb.append(writer.toString());
        return sb.toString();
    }
}
