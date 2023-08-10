package com.liubz.androidtea.utils;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 8/10/23 5:43 PM
 */
public class NdkUtils {
    static {
        System.loadLibrary("ndkdemotest-jni");
    }

    public static native String getStringFromNdk();
}
