package com.android.liubz.androidtea.java.concurrency.pairtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-08-29
 */
public class ExplicitPairManager1 extends PairSafeManager {

    private Lock mLock = new ReentrantLock();

    @Override
    public void increment() {
        mLock.lock();

        try {
            cp.incrementX();
            cp.incrementY();
            store(getPair());
        } finally {
            mLock.unlock();
        }
    }
}
