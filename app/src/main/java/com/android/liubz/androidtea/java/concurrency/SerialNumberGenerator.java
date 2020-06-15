package com.android.liubz.androidtea.java.concurrency;

/**
 * Created by liubaozhu on 2019-08-25
 */
public class SerialNumberGenerator {

    private static volatile int mSerialNumber = 0;

    public static int nextSerialNumber() {
        return mSerialNumber++; // Not thread-safe
    }
}
