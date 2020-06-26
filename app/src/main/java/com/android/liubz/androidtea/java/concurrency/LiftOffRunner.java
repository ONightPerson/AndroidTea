package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.BlockingQueue;

/**
 * author: created by liubaozhu on 2020/6/26
 * email: liubaozhu@baidu.com
 */
public class LiftOffRunner implements Runnable {

    private BlockingQueue<LiftOff> mRocketQueue;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        mRocketQueue = queue;
    }

    public void add (LiftOff lo) {
        try {
            mRocketQueue.add(lo);
        } catch (IllegalStateException e) {
            System.out.println("Interrupt while putting");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = mRocketQueue.take();
                rocket.run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting LiftOffRunner");
    }
}
