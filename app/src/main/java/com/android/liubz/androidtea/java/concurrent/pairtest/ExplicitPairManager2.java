package com.android.liubz.androidtea.java.concurrent.pairtest;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-08-29
 */
public class ExplicitPairManager2 extends PairSafeManager {

    private ReentrantLock mLock = new ReentrantLock();
    @Override
    public void increment() {
        CustomPair tmp;
        mLock.lock();

        try {
            cp.incrementX();
            cp.incrementY();
            tmp = getPair();

        } finally {
            mLock.unlock();
        }
        store(tmp);
    }
}
