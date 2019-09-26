package com.android.liubz.androidtea.java.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-08-06
 */
public class LiftOffRunnable implements Runnable {

    protected int countDown = 10; // default
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOffRunnable() {
    }

    public LiftOffRunnable(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff)") + ").";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
//            Thread.yield();
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new LiftOffRunnable()).start();
        new Thread(new LiftOffRunnable()).start();
    }
}
