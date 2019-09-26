package com.android.liubz.androidtea.java.concurrent.coordinate;

/**
 * Created by liubaozhu on 2019-09-09
 */
class Task2 implements Runnable {

    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingForCall();
    }
}
