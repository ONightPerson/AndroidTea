package com.android.liubz.androidtea.java.concurrent.coordinate;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class Car {

    public boolean waxOn;

    public synchronized void wax() throws InterruptedException {
        waxOn = true;
//        System.out.println("waxing car");
        TimeUnit.MILLISECONDS.sleep(200);
        notifyAll();
    }

    public synchronized void polish() throws InterruptedException {
        waxOn = false;
//        System.out.println("polishing car");
        TimeUnit.MILLISECONDS.sleep(150);
        notifyAll();
    }

    public synchronized void waitingToWax() throws InterruptedException {
        if (waxOn == false) {
//            System.out.println("waiting for waxing");
            wait();
        }
    }

    public synchronized void waitingToPolish() throws InterruptedException {
        if (waxOn = true) {
//            System.out.println("waiting for polishing");
            wait();
        }
    }
}
