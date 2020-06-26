package com.android.liubz.androidtea.java.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */

class WaitTask implements Runnable {

    @Override
    public void run() {
        try {
            out.println("start waiting.");
            synchronized (this) {
                wait();
            }
            out.println("start do something.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class WakeTask implements Runnable {

    private Runnable task;

    public WakeTask(Runnable task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(3);
            synchronized (task) {
                task.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Exercise21 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable waitTask = new WaitTask();
        exec.execute(waitTask);
        exec.execute(new WakeTask(waitTask));

        exec.shutdown();
        exec.awaitTermination(6, TimeUnit.SECONDS);

    }
}
