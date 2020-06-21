package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-08-18
 */
public class AttemptLocking {
    private ReentrantLock mLock = new ReentrantLock();

    public void untimed() {
        boolean captured = mLock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                mLock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;

        try {
            captured = mLock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                mLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking al = new AttemptLocking();
        al.untimed();
        al.timed();

        // Now create a separate task to grab the lock
        new Thread() {
            {
                setDaemon(true);
            }
            public void run() {
                al.mLock.lock();
                System.out.println("lock acquired");
            }
        }.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        al.untimed();
        al.timed();
    }

}
