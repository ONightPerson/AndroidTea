package com.android.liubz.androidtea;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.liubz.androidtea.hook.InstrumentationProxy;
import com.iotc.sampleIOTC.Sample_IOTCAPIs;
import com.philips.lighting.quickstart.MyApplicationActivity;
import com.philips.lighting.quickstart.PHHomeActivity;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    private static final int TAKE_PHOTO = 1;

    private Button mClickLaunchBtn;
    private Uri mImageUri;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: begin");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startActivity(new Intent(this, SocketTestActivity.class));
        initViews();
        Log.e(TAG, "onCreate: end");

    }

    private void initViews() {
        mClickLaunchBtn = findViewById(R.id.click_to_launch);
        mClickLaunchBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v == mClickLaunchBtn) {
//            startActivity(new Intent(this, SafeUrlActivity.class));
//            startService(new Intent(this, MusicPlayService.class));
//            Intent intent = new Intent(this, AccessibilityTestActivity.class);
//
//            AccessibilityJumpActivity.show(this, intent);
//            Intent intent = new Intent(Intent.ACTION_VIEW);
//            intent.setData(Uri.parse("https://www.baidu.com"));
//            startActivity(intent);
//            Intent intent = new Intent(this, AccessibilityTestActivity.class);
//            AccessibilityJumpActivity.show(this, intent);

//            Intent intent = new Intent(this, ViewPropertyActivity.class);
//
//            Log.e(TAG, "onClick: " + Environment.getExternalStorageDirectory().getAbsolutePath());
//
//            Worker worker = new Worker();
//            worker.name = "j";
//            Log.i(TAG, "onClick: worker: " + worker);
//            intent.putExtra("extra.worker", worker);
//            startActivity(intent);
//
//            Calendar calendar = Calendar.getInstance();
//            Log.i(TAG, "onClick: calendar: " + "\n"
//                    + "era: " + calendar.get(Calendar.ERA) + "\n"
//                    + "year: " + calendar.get(Calendar.YEAR) + "\n"
//                    + "month: " + calendar.get(Calendar.MONTH) + "\n"
//                    + "week of year: " + calendar.get(Calendar.WEEK_OF_YEAR) + "\n"
//                    + "week of month: " + calendar.get(Calendar.WEEK_OF_MONTH) + "\n"
//                    + "date: " + calendar.get(Calendar.DATE) + "\n" // same as DAY_OF_MONTH
//                    + "day of month: " + calendar.get(Calendar.DAY_OF_MONTH) + "\n"
//                    + "day of year: " + calendar.get(Calendar.DAY_OF_YEAR) + "\n"
//                    + "day of week: " + calendar.get(Calendar.DAY_OF_WEEK) + "\n"
//                    + "day of week in month: " + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH) + "\n"
//                    + "am or pm: " + calendar.get(Calendar.AM_PM) + "\n"
//                    + "hour: " + calendar.get(Calendar.HOUR) + "\n"
//                    + "hour of day: " + calendar.get(Calendar.HOUR_OF_DAY) + "\n"
//                    + "MINUTE: " + calendar.get(Calendar.MINUTE) + "\n"
//                    + "second: " + calendar.get(Calendar.SECOND) + "\n"
//                    + "MILLISECOND: " + calendar.get(Calendar.MILLISECOND) + "\n");
//            Log.i(TAG, "bluetooth address: " + getBtAddressByReflection());
//            Log.e(TAG, "bluetooth address: " + BluetoothAdapter.getDefaultAdapter().getAddress());

//            Log.i(TAG, "onClick: filepath:" + getFilesDir().getAbsolutePath() + "/");

//            Intent intent = new Intent(this, SignalStrengthTestActivity.class);
//            startActivity(intent);
//
//            String IP = "192.168.31.143";
//            try {
//                Process p = Runtime.getRuntime().exec("ping -c 1 -W 1 " + IP);
//                int status = p.waitFor();
//                Log.e(TAG, "status: " + status);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

//            Intent intent = new Intent(this, MyIntentService.class);
//            intent.putExtra("task_action", "task1");
//            startService(intent);
//
//            Intent intent1 = new Intent(this, MyIntentService.class);
//            intent1.putExtra("task_action", "task2");
//            startService(intent1);
//
//
//            Intent intent2 = new Intent(this, MyIntentService.class);
//            intent2.putExtra("task_action", "task3");
//            startService(intent2);


//            UDPScanner.doScan(this);

//            mImageUri = ImageUtils.getImageUri(this, "output_image.jpg");
//            // 启动相机程序
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
//            startActivityForResult(intent, TAKE_PHOTO);

//            validateFilePathNull();
//            Log.i(TAG, "onClick: path1: " + getExternalFilesDir(null)
//                    + ", path2: " + getExternalFilesDir(Environment.DIRECTORY_MOVIES));
//            DecryptUtils.decryptData(this);
//            Intent intent = new Intent(this, ThirdActivity.class);
//            startActivity(intent);
//            NotificationUtils.sendNotification(this);
//            String encodedString = Base64.encodeToString("whoislcj".getBytes(), Base64.DEFAULT);
//            Log.e("Base64", "Base64---->" + encodedString);
//
//            String decodedString =new String(Base64.decode(encodedString,Base64.DEFAULT));
//            Log.e("Base64", "Base64---->" + decodedString);
//            InstrumentationProxy.replaceActivityInstrumentation(this);
//            InstrumentationProxy.replaceContextInstrumentation();
//            getApplicationContext().startActivity(new Intent(this, Sample_IOTCAPIs.class));

            // Hue Bridge
//            startActivity(new Intent(this, PHHomeActivity.class));

            Log.i(TAG, "onClick: " + Environment.getExternalStorageDirectory());
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        // 展示拍摄的照片
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                                .openInputStream(mImageUri));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
                break;
        }
    }

    public static String getBtAddressByReflection() {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Field field = null;
        try {
            field = BluetoothAdapter.class.getDeclaredField("mService");
            field.setAccessible(true);
            Object bluetoothManagerService = field.get(bluetoothAdapter);
            if (bluetoothManagerService == null) {
                return null;
            }
            Method method = bluetoothManagerService.getClass().getMethod("getAddress");
            if(method != null) {
                Object obj = method.invoke(bluetoothManagerService);
                if(obj != null) {
                    return obj.toString();
                }
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }


    private void validateFilePathNull() {
        String path = null;
        File file = new File(path);
        if (file.exists()) {
            return;
        }
    }
}
