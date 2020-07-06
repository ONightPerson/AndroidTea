package com.liubz.androidtea.cherish.concurrency.pairtest;

/**
 * Created by liubaozhu on 2019-08-28
 */
public class PairManipulator implements Runnable {
    private PairSafeManager pm;

    public PairManipulator(PairSafeManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true) {
            pm.increment();
        }
    }

    @Override
    public String toString() {
        return "[Pair:" + pm.getPair() + ", checkCounter: " + pm.checkCounter.get() + "]";
    }
}
