package com.android.liubz.androidtea.java.concurrent;

/**
 * Created by liubaozhu on 2019-08-18
 */
public class EvenGenerator extends IntGenerator {
    private int mCurValue = 0;

    @Override
    public synchronized int next() {
        ++mCurValue;
        Thread.yield();
        ++mCurValue;
        return mCurValue;
    }

    public static void main(String[] args) {
        IntGenerator g = new EvenGenerator();
        EvenChecker.test(g);
    }
}
