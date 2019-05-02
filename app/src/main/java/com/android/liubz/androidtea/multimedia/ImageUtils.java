package com.android.liubz.androidtea.multimedia;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.util.Log;

import java.io.File;
import java.io.IOException;

public class ImageUtils {
    private static final String TAG = "ImageUtils";

    public static Uri getImageUri(Context context, String imageName) {
        Log.i(TAG, "captureImage: getExternalCacheDir: " + context.getExternalCacheDir());
        Log.i(TAG, "captureImage: getCacheDir: " + context.getCacheDir());
        File outputImage = new File(context.getExternalCacheDir(), imageName);
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri imageUri;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N) {
            imageUri = FileProvider.getUriForFile(context,
                    context.getPackageName() + ".provider", outputImage);
        } else {
            imageUri = Uri.fromFile(outputImage);
        }
        Log.i(TAG, "getImageUri: version: " + Build.VERSION.SDK_INT + ", imageUri: " + imageUri);
        return imageUri;
    }
}
