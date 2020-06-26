package com.android.liubz.androidtea.java.concurrency.coordinate;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class WaxTask implements Runnable {
    private Car mCar;

    public WaxTask(Car car) {
        mCar = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {

                System.out.println("start waxing");
                TimeUnit.MILLISECONDS.sleep(200);
                System.out.println("finish waxing");
                mCar.notifyPolishing();
                mCar.waitingForWaxing();
            }
        } catch (InterruptedException e) {
            System.out.println("exiting waxing operation via interrupt");
        }

        System.out.println("Ending waxing task");
    }
}
