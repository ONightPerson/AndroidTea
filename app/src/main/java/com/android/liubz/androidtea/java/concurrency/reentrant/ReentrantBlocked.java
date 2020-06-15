package com.android.liubz.androidtea.java.concurrency.reentrant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-09-07
 */
class ReentrantBlocked implements Runnable {
    BlockedMutex mMutex = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("Waiting for f() in BlockedMutex");
        mMutex.f();
        System.out.println("Broken out of blocked call");
    }

    class BlockedMutex {
        private ReentrantLock mLock = new ReentrantLock();
        public BlockedMutex() {
            // Acquired int immediately in order to demonstrate interruption
            // of a task blocked on a ReentrantLock
            mLock.lock();
        }

        public void f() {
            try {
                mLock.lockInterruptibly();
                System.out.println("lock acquired in f()");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}
