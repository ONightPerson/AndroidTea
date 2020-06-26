package com.android.liubz.androidtea.java.concurrency.coordinate;

import java.util.concurrent.TimeUnit;

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
                mCar.waitingForPolishing();
                System.out.println("start polishing");
                TimeUnit.MILLISECONDS.sleep(150);
                System.out.println("finish polishing");
                mCar.notifyWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exception occurs and exiting polishing task");
        }
    }
}
