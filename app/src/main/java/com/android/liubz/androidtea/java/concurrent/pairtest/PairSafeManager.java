package com.android.liubz.androidtea.java.concurrent.pairtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by liubaozhu on 2019-08-28
 */
abstract class PairSafeManager {

    AtomicInteger checkCounter = new AtomicInteger(0);
    protected CustomPair cp = new CustomPair();
    private List<CustomPair> storage = Collections.synchronizedList(new ArrayList<>());

    public synchronized CustomPair getPair() {
        return new CustomPair(cp.getX(), cp.getY());
    }

    protected void store(CustomPair cp) {
        storage.add(cp);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
        }
    }

    public abstract void increment();
}
