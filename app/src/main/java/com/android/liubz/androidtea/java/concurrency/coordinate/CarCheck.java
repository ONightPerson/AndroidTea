package com.android.liubz.androidtea.java.concurrency.coordinate;

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
        exec.execute(new WaxTask(car));
        exec.execute(new PolishTask(car));

        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
    }
}
