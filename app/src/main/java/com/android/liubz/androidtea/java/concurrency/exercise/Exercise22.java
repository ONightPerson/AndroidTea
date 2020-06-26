package com.android.liubz.androidtea.java.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */

class SleepTask implements Runnable {

    private AtomicBoolean status = new AtomicBoolean(false);

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
            status.set(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean getStatus() {
        return status.get();
    }

    public void setStatus(boolean status) {
        this.status.set(status);
    }
}

class BusyWaitTask implements Runnable {

    private SleepTask task;
    public BusyWaitTask(SleepTask task) {
        this.task = task;
    }

    @Override
    public void run() {
        busyWait();
    }

    private void busyWait() {
        while (true) {
            if (task.getStatus() == true) {
                task.setStatus(false);
                System.out.println("set status to false");
            }
        }
    }
}
public class Exercise22 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        SleepTask sleepTask = new SleepTask();
        exec.execute(sleepTask);
        TimeUnit.MILLISECONDS.sleep(100);
        exec.execute(new BusyWaitTask(sleepTask));

        exec.shutdown();
    }
}
