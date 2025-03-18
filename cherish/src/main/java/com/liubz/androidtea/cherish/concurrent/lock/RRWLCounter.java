package com.liubz.androidtea.cherish.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RRWLCounter {
    private final ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
    private final Lock r = rrwl.readLock();
    private final Lock w = rrwl.writeLock();
    private int count = 0;

    public int getCount() {
        r.lock();
        try {
            return count;
        } finally {
            r.unlock();
        }
    }

    public void increment() {
        w.lock();
        try {
            count++;
        } finally {
            w.unlock();
        }
    }
}
