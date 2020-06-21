package com.android.liubz.androidtea.java.concurrency;


import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */
public class AtomicIntegerTest implements Runnable {

    private AtomicInteger mValue = new AtomicInteger(0);

    public int increment() {
        return mValue.addAndGet(2);
    }

    public int getValue() {
        return mValue.get();
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {

            increment();
        }
    }

    public static void main(String[] args) {

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("task aborting");
                System.exit(0);
            }
        }, 5000);


        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicIntegerTest task = new AtomicIntegerTest();
        exec.execute(task);

        while (true) {
            int val = task.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }

    }
}
