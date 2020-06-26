package com.android.liubz.androidtea.java.concurrency.coordinate;

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
                mCar.wax();
                mCar.waitingToPolish();
            }
        } catch (InterruptedException e) {
            System.out.println("exiting waxing operation via interrupt");
        }

        System.out.println("Ending waxing task");
    }
}
