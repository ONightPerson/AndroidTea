package com.android.liubz.androidtea.java.concurrency.pairtest;

/**
 * Created by liubaozhu on 2019-08-28
 */
public class PairChecker implements Runnable {
    private PairSafeManager pm;

    public PairChecker(PairSafeManager pm) {
        this.pm = pm;
    }
    @Override
    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }

    @Override
    public String toString() {
        return "[Pair:" + pm.getPair() + ", checkCounter: " + pm.checkCounter.get() + "]";
    }
}
