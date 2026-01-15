package com.liubz.androidtea.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.liubz.androidtea.utils.BitmapUtils;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;

public class ImageLoader {
    private static final String TAG = "ImageLoader";
    private static final long DISK_CACHE_SIZE = 1024 * 1024 * 50; // 50MB
    private static final int DISK_CACHE_INDEX = 0;

    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final long KEEP_ALIVE = 1L;

    private final LruCache<String, Bitmap> mMemoryCache;
    private DiskLruCache mDiskCache;
    private final OkHttpClient mOkHttpClient;
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    private static final ThreadFactory sThreadFactory = new ThreadFactory() {
        private final AtomicInteger mCount = new AtomicInteger(1);
        public Thread newThread(Runnable r) {
            return new Thread(r, "ImageLoader#" + mCount.getAndIncrement());
        }
    };

    private static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(
            CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
            KEEP_ALIVE, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(), sThreadFactory);

    private ImageLoader(Context context) {
        mOkHttpClient = new OkHttpClient();
        
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;
        mMemoryCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap bitmap) {
                return bitmap.getRowBytes() * bitmap.getHeight() / 1024;
            }
        };

        File diskCacheDir = getDiskCacheDir(context, "bitmap");
        if (!diskCacheDir.exists()) {
            diskCacheDir.mkdirs();
        }
        try {
            mDiskCache = DiskLruCache.open(diskCacheDir, 1, 1, DISK_CACHE_SIZE);
        } catch (IOException e) {
            Log.e(TAG, "Init DiskLruCache failed", e);
        }
    }

    public static ImageLoader build(Context context) {
        return new ImageLoader(context);
    }

    public void displayImage(final String url, final ImageView imageView, final int reqWidth, final int reqHeight) {
        String key = hashKeyFromUrl(url);
        Bitmap bitmap = mMemoryCache.get(key);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        THREAD_POOL_EXECUTOR.execute(() -> {
            Bitmap result = loadBitmap(url, reqWidth, reqHeight);
            if (result != null) {
                mMainHandler.post(() -> imageView.setImageBitmap(result));
            }
        });
    }

    private Bitmap loadBitmap(String url, int reqWidth, int reqHeight) {
        String key = hashKeyFromUrl(url);
        Bitmap bitmap = mMemoryCache.get(key);
        if (bitmap != null) return bitmap;

        try {
            bitmap = loadBitmapFromDiskCache(key, reqWidth, reqHeight);
            if (bitmap != null) return bitmap;

            bitmap = loadBitmapFromHttp(url, reqWidth, reqHeight);
        } catch (IOException e) {
            Log.e(TAG, "Load bitmap failed", e);
        }

        return bitmap;
    }

    private Bitmap loadBitmapFromHttp(String url, int reqWidth, int reqHeight) throws IOException {
        if (mDiskCache == null) return null;

        String key = hashKeyFromUrl(url);
        DiskLruCache.Editor editor = mDiskCache.edit(key);
        if (editor != null) {
            // Glide 的 DiskLruCache.Editor 使用 getFile(index) 来获取文件
            File file = editor.getFile(DISK_CACHE_INDEX);
            try (OutputStream outputStream = new FileOutputStream(file)) {
                if (downloadUrlToStream(url, outputStream)) {
                    editor.commit();
                } else {
                    editor.abort();
                }
            }
            mDiskCache.flush();
        }
        return loadBitmapFromDiskCache(key, reqWidth, reqHeight);
    }

    private Bitmap loadBitmapFromDiskCache(String key, int reqWidth, int reqHeight) throws IOException {
        if (mDiskCache == null) return null;
        
        // Glide 的 DiskLruCache 使用 get(key) 返回 Value 对象
        DiskLruCache.Value value = mDiskCache.get(key);
        if (value != null) {
            File file = value.getFile(DISK_CACHE_INDEX);
            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                FileDescriptor fd = fileInputStream.getFD();
                Bitmap bitmap = BitmapUtils.decodeSampledBitmapFromFileDescriptor(fd, reqWidth, reqHeight);
                if (bitmap != null) {
                    mMemoryCache.put(key, bitmap);
                }
                return bitmap;
            }
        }
        return null;
    }

    private boolean downloadUrlToStream(String urlString, OutputStream outputStream) {
        Request request = new Request.Builder().url(urlString).build();
        try (Response response = mOkHttpClient.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                try (BufferedSink sink = Okio.buffer(Okio.sink(outputStream))) {
                    sink.writeAll(response.body().source());
                    return true;
                }
            }
        } catch (IOException e) {
            Log.e(TAG, "Download failed: " + urlString, e);
        }
        return false;
    }

    private String hashKeyFromUrl(String url) {
        String cacheKey;
        try {
            final MessageDigest mDigest = MessageDigest.getInstance("MD5");
            mDigest.update(url.getBytes());
            cacheKey = bytesToHexString(mDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            cacheKey = String.valueOf(url.hashCode());
        }
        return cacheKey;
    }

    private String bytesToHexString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(0xFF & b);
            if (hex.length() == 1) sb.append('0');
            sb.append(hex);
        }
        return sb.toString();
    }

    private File getDiskCacheDir(Context context, String uniqueName) {
        return new File(context.getCacheDir(), uniqueName);
    }
}
