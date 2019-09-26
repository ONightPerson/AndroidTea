package com.android.liubz.androidtea.java.concurrent;

/**
 * Created by liubaozhu on 2019-08-18
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();
    public void cancel() {
        canceled = true;
    }
    public boolean isCanceled() {
        return canceled;
    }
}
