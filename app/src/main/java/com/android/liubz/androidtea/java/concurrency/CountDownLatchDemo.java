package com.android.liubz.androidtea.java.concurrency;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/26
 * email: liubaozhu@baidu.com
 */

class TaskPortion implements Runnable {

    private static int sCounter = 0;

    private int mId = sCounter++;
    private CountDownLatch mCountDownLatch;
    private Random mRandom;

    public TaskPortion(CountDownLatch latch) {
        mCountDownLatch = latch;
        mRandom = ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        try {
            System.out.println(this + " do task");
            TimeUnit.MILLISECONDS.sleep(100 + mRandom.nextInt(200));
            mCountDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("TaskPortion %1$-3d", mId);
    }
}

class WaitTask implements Runnable {

    private CountDownLatch mCountDownLatch;
    private static int sCounter = 0;
    private int mId = sCounter++;

    public WaitTask(CountDownLatch latch) {
        mCountDownLatch = latch;
    }

    @Override
    public void run() {
        try {
            mCountDownLatch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return String.format("WaitTask %1$-3d", mId);
    }
}

public class CountDownLatchDemo {
    private static final int SIZE = 100;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 5; i++) {
            exec.execute(new WaitTask(latch));
        }

        for (int i = 0; i <SIZE; i++) {
            exec.execute(new TaskPortion(latch));
        }

        exec.shutdown();
    }
}
