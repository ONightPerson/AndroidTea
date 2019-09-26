package com.android.liubz.androidtea.java.concurrent.pairtest;

/**
 * Created by liubaozhu on 2019-08-28
 */
public class PairManager1 extends PairSafeManager {

    @Override
    public synchronized void increment() {
        cp.incrementX();
        cp.incrementY();
        store(getPair());

    }
}
