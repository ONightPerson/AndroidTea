package com.android.liubz.androidtea.java.concurrent;

import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * Created by liubaozhu on 2019-08-10
 */
public class DaemonThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
