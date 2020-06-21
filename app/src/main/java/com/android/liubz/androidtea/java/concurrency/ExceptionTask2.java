package com.android.liubz.androidtea.java.concurrency;

import android.support.annotation.NonNull;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * author: created by liubaozhu on 2020/6/20
 * email: liubaozhu@baidu.com
 */

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught thread " + t + "'s exception: " + e);
    }
}

class MyThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread t = new Thread(r);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        return t;
    }
}

public class ExceptionTask2 implements Runnable {

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException("exception task");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new MyThreadFactory());
        exec.execute(new ExceptionTask2());
    }
}
