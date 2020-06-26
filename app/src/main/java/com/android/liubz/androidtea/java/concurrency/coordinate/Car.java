package com.android.liubz.androidtea.java.concurrency.coordinate;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class Car {

    private boolean waxOn;

    public synchronized void wax() throws InterruptedException {
        waxOn = true;
        System.out.println("start waxing");
        TimeUnit.MILLISECONDS.sleep(200);
        System.out.println("finish waxing, ready to polish.");
        notifyAll();
    }

    public synchronized void polish() throws InterruptedException {
        waxOn = false;
        System.out.println("start polishing");
        TimeUnit.MILLISECONDS.sleep(150);
        System.out.println("finish polishing, ready to wax.");
        notifyAll();
    }

    public synchronized void waitingToWax() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitingToPolish() throws InterruptedException {
        while (waxOn = true) {
            wait();
        }
    }
}
