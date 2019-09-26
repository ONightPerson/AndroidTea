package com.android.liubz.androidtea.java.concurrent.ornamentalgarden;

import java.util.Random;

/**
 * Created by liubaozhu on 2019-09-03
 */
class Count {

    private int count = 0;
    private Random rand = new Random(47);

    public synchronized int increment() {
        int tmp = count;
        if (rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++tmp);
    }

    public synchronized int value() {
        return count;
    }
}
