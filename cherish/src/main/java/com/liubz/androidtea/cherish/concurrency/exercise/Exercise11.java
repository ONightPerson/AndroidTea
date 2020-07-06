package com.liubz.androidtea.cherish.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: created by liubaozhu on 2020/6/20
 * email: liubaozhu@baidu.com
 */

class Increment {

    int i = 0;
    int j = 0;
    boolean equal = true;

    public synchronized void increment() {
        i++;
        Thread.yield();
        j++;
        System.out.println(Thread.currentThread() + " increment i: " + i + ", j: " + j);
    }

    public synchronized boolean checkEqual() {
        if (i != j) {
            equal = false;
        }
        return equal;
    }
}

class IncrementTask implements Runnable {

    private Increment mIncrement;

    public IncrementTask(Increment increment) {
        mIncrement = increment;
    }

    @Override
    public void run() {
        while (mIncrement.checkEqual()) {
            mIncrement.increment();
        }
    }
}

public class Exercise11 {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        Increment increment = new Increment();

        for (int i = 0; i < 10; i++) {
            exec.execute(new IncrementTask(increment));
        }

        exec.shutdown();
    }

}
