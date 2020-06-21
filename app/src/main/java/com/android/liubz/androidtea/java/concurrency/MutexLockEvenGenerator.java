package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-08-18
 */
public class MutexLockEvenGenerator extends IntGenerator {
    private int mCurValue = 0;
    private Lock mLock = new ReentrantLock();

    @Override
    public int next() {
        mLock.lock();
        try {
            ++mCurValue;
            Thread.yield();
            ++mCurValue;
            return mCurValue;
        } finally {
            mLock.unlock();
        }
    }

    public static void main(String[] args) {
        IntGenerator g = new MutexLockEvenGenerator();
        EvenChecker.test(g);
    }
}
