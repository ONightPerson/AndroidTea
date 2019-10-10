package com.android.liubz.androidtea.java.concurrent.pairtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-08-29
 */
public class ExplicitPairManager1 extends PairSafeManager {

    private ReentrantLock mLock = new ReentrantLock();
    @Override
    public synchronized void increment() {
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