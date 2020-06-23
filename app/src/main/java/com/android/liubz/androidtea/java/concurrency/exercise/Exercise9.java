package com.android.liubz.androidtea.java.concurrency.exercise;

import androidx.annotation.NonNull;

import java.util.concurrent.ThreadFactory;

/**
 * Created by liubaozhu on 2019-08-10
 */
public class Exercise9 implements Runnable {
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public Exercise9() {
    }

    @Override
    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {

        while (true) {
            for (int i = 1; i < 100000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static class SimplePrioritiesFactory implements ThreadFactory {

        private int priority;

        public SimplePrioritiesFactory(int priority) {
            this.priority = priority;
        }

        @Override
        public Thread newThread(@NonNull Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(priority);
            return t;
        }
    }
}
