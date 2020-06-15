package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/10
 * email: liubaozhu@baidu.com
 */
public class SleepingTask extends LiftOffRunnable {

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());

            try {
                TimeUnit.MICROSECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
