package com.android.liubz.androidtea.java.concurrency.coordinate;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class SynchronizedCar extends Car {

    private boolean waxOn = true;

    @Override
    public synchronized void notifyWaxing() throws InterruptedException {
        waxOn = true;
        notifyAll();
    }

    @Override
    public synchronized void notifyPolishing() throws InterruptedException {
        waxOn = false;
        notifyAll();
    }

    @Override
    public synchronized void waitingForWaxing() throws InterruptedException {
        while (waxOn == false) {
            System.out.println("start waitingForWaxing");
            wait();
            System.out.println("finish waitingForWaxing");
        }
    }

    @Override
    public synchronized void waitingForPolishing() throws InterruptedException {
        while (waxOn == true) {
            System.out.println("start waitingForPolishing");
            wait();
            System.out.println("finish waitingForPolishing");
        }
    }
}
