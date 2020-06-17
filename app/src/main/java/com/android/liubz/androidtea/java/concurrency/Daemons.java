package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/16
 * email: liubaozhu@baidu.com
 */
class Daemon implements Runnable {

    Thread[] tArr = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = new Thread(new DaemonSpawn());
            tArr[i].start();
            System.out.println("DaemonSpawn " + i + " started.");
        }

        for (int i = 0; i < tArr.length; i++) {
            System.out.println("t[" + i + "].isDaemon = " + tArr[i].isDaemon());
        }
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("Daemon thread exception: " + e);
            }
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {

    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread d = new Thread(new Daemon());
        d.setDaemon(true);
        d.start();
        System.out.println("d.isDaemon = " + d.isDaemon());

        TimeUnit.MILLISECONDS.sleep(50);
    }
}
