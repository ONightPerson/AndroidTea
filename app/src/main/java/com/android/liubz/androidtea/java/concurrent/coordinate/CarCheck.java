package com.android.liubz.androidtea.java.concurrent.coordinate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-08
 */
public class CarCheck {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Car car = new Car();
        exec.execute(new Wax(car));
        exec.execute(new Polish(car));

        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
