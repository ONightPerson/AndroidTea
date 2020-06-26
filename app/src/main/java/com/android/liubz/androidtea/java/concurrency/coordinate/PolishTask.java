package com.android.liubz.androidtea.java.concurrency.coordinate;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class PolishTask implements Runnable {
    private Car mCar;

    public PolishTask(Car car) {
        mCar = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                mCar.waitingToWax();
                mCar.polish();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception occurs and exiting polishing task");
        }
    }
}
