package com.android.liubz.androidtea.java.concurrent.coordinate;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class Wax implements Runnable {
    private Car mCar;

    public Wax(Car car) {
        mCar = car;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("wax");
                mCar.wax();
                mCar.waitingToPolish();
            }
        } catch (InterruptedException e) {
            System.out.println("exiting waxing operation via interrupt");
        }

        System.out.println("Ending waxing task");
    }
}
