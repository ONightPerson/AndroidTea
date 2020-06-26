package com.android.liubz.androidtea.java.concurrency.coordinate;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class LockCar extends Car {

    private Lock mLock = new ReentrantLock();
    private Condition mCondition = mLock.newCondition();
    private boolean waxOn = true;

    @Override
    public void notifyWaxing() throws InterruptedException {
        mLock.lock();
        try {
            waxOn = true;
            mCondition.signalAll();
        } finally {
            mLock.unlock();
        }

    }

    @Override
    public void notifyPolishing() throws InterruptedException {
        mLock.lock();
        try {
            waxOn = false;
            mCondition.signalAll();
        } finally {
            mLock.unlock();
        }
    }

    @Override
    public void waitingForWaxing() throws InterruptedException {
        mLock.lock();
        System.out.println("start waitingForWaxing");
        try {
            while (waxOn == false) {
                mCondition.await();
            }
        } finally {
            System.out.println("finish waitingForWaxing");
            mLock.unlock();
        }
    }

    @Override
    public void waitingForPolishing() throws InterruptedException {
        mLock.lock();
        System.out.println("start waitingForPolishing");
        try {
            while (waxOn == true) {
                mCondition.await();
            }
        } finally {
            System.out.println("finish waitingForPolishing");
            mLock.unlock();
        }
    }
}
