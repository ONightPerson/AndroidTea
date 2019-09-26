package com.android.liubz.androidtea.java.concurrent.ornamentalgarden;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * Created by liubaozhu on 2019-09-07
 */
class Entrance implements Runnable {
    private static Count sCount = new Count();
    private static List<Entrance> sEntrances = new ArrayList<>();
    private int mNumber = 0;
    private final int mId;
    private static volatile boolean sCanceled = false;

    public static void cancel() {
        sCanceled = true;
    }

    public Entrance(int id) {
        mId = id;
        sEntrances.add(this);
    }

    @Override
    public void run() {
        while (!sCanceled) {
            synchronized (this) {
                ++mNumber;
            }

            out.println(this + " Total: " + sCount.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                out.println(e);
            }
        }
        out.println("Stopping " + this);
    }

    public synchronized int getValue() {
        return mNumber;
    }

    @Override
    public String toString() {
        return "Entrance " + mId + ": " + getValue();
    }

    public static int getTotalCount() {
        return sCount.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for (Entrance e : sEntrances) {
            sum += e.getValue();
        }
        return sum;
    }
}
