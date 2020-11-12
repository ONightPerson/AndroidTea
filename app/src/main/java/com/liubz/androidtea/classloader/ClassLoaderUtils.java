package com.liubz.androidtea.classloader;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

/**
 * Created by liubaozhu on 2020/11/12
 */
public class ClassLoaderUtils {
    private static final String TAG = "ClassLoaderUtils";

    public static void showClassLoaderRelations(Context cxt) {
        ClassLoader loader = cxt.getClassLoader();
        while (loader != null) {
            Log.i(TAG, "showClassLoaderRelations: " + loader);
            loader = loader.getParent();
        }
        Log.i(TAG,
                "ClassLoaderUtils.class.getClassLoader(): " + ClassLoaderUtils.class.getClassLoader());
        Log.i(TAG, "Activity.class.getClassLoader(): " + Activity.class.getClassLoader());
    }
}
