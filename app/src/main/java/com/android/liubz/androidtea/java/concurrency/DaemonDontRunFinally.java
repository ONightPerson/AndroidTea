package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/16
 * email: liubaozhu@baidu.com
 */

class ADaemon implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                System.out.println("ADaemon task interrupt: " + e);
            } finally {
                System.out.println("finally execute.");
            }
        }
    }
}

public class DaemonDontRunFinally {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new ADaemon());
//        t.setDaemon(true);
        t.start();

//        TimeUnit.MILLISECONDS.sleep(100);
    }
}
