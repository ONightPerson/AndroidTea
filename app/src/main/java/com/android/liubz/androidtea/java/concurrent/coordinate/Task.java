package com.android.liubz.androidtea.java.concurrent.coordinate;

/**
 * Created by liubaozhu on 2019-09-09
 */
public class Task implements Runnable {

    static Blocker sBlocker = new Blocker();

    @Override
    public void run() {
        sBlocker.waitingForCall();
    }
}
