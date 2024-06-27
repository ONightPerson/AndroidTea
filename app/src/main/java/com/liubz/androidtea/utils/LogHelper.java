package com.liubz.androidtea.utils;

import android.util.Log;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/27/24 10:35 AM
 */
public class LogHelper {
    private static final String LOG_TAG = "AndroidTea_";

    public static void i(String tag, String msg, Object... args) {
        Log.i(LOG_TAG + tag, String.format(msg, args));
    }

    public static void d(String tag, String msg, Object... args) {
        Log.d(LOG_TAG + tag, String.format(msg, args));
    }

    public static void e(String tag, Throwable e) {
        Log.d(LOG_TAG + tag, getTraceFromException(e));
    }

    public static String getTraceFromException(Throwable e) {
        String trace = "";
        if (e == null) {
            return trace;
        }
        StackTraceElement[] elements = e.getStackTrace();
        for (int i = 0; i < elements.length; i++) {
            trace = trace + elements[i].toString() + '\n';
        }
        return trace;
    }
}
