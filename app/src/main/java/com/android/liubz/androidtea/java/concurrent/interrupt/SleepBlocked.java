package com.android.liubz.androidtea.java.concurrent.interrupt;

import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Created by liubaozhu on 2019-09-07
 */
class SleepBlocked implements Runnable {

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch (InterruptedException e) {
            out.println("SleepBlocked InterruptedException");
        }
        out.println("Exiting SleepBlocked.run()");
    }
}
