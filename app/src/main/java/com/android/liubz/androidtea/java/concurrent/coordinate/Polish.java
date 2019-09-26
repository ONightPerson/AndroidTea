package com.android.liubz.androidtea.java.concurrent.coordinate;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class Polish implements Runnable {
    private Car mCar;

    public Polish(Car car) {
        mCar = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                mCar.waitingToWax();
                System.out.println("polish");
                mCar.polish();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception occurs and exiting polishing task");
        }
    }
}
