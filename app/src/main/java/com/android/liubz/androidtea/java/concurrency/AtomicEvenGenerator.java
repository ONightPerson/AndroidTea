package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-08-18
 */
public class AtomicEvenGenerator extends IntGenerator {
    private AtomicInteger mCurValue = new AtomicInteger(0);

    @Override
    public int next() {
        return mCurValue.addAndGet(2);
    }

    public static void main(String[] args) {
        IntGenerator g = new AtomicEvenGenerator();
        EvenChecker.test(g);
    }
}
