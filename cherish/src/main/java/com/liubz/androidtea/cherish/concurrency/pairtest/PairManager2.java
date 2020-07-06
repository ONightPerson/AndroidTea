package com.liubz.androidtea.cherish.concurrency.pairtest;

/**
 * Created by liubaozhu on 2019-08-28
 */
public class PairManager2 extends PairSafeManager {

    @Override
    public void increment() {
        CustomPair tmp;
        synchronized (this) {
            cp.incrementX();
            cp.incrementY();
            tmp = getPair();
        }
        store(tmp);
    }
}