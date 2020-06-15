package com.android.liubz.androidtea.java.concurrency;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by liubaozhu on 2019-11-05
 */
public class FIFIMutex {
    private final AtomicBoolean mLocked = new AtomicBoolean(false);
    private final Queue<Thread> mWaiters = new ConcurrentLinkedQueue<>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        mWaiters.add(current);

        while (mWaiters.peek() != current) {
            System.out.println("to park " + Thread.currentThread().getName());
            LockSupport.park(this);
            if (Thread.interrupted()) {
                System.out.println(Thread.currentThread().getName() + " was interrupted");
                wasInterrupted = true;
            }
        }
        mWaiters.remove();
        if (wasInterrupted) {
            current.interrupt();
        }
    }

    public void unlock() {
        mLocked.set(false);
        LockSupport.unpark(mWaiters.peek());
    }
}
