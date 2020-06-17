package com.android.liubz.androidtea.java.concurrency;

/**
 * author: created by liubaozhu on 2020/6/17
 * email: liubaozhu@baidu.com
 */
class Sleeper extends Thread {

    private int mDuration;
    public Sleeper(String name, int sleepTime) {
        super(name);
        mDuration = sleepTime;
        start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(mDuration);
        } catch (InterruptedException e) {
            System.out.println("Sleeper thread interrupt: " + e);
            return;
        }

        System.out.println(getName() + " has awakened");
    }
}

class Joiner extends Thread {

    private Sleeper mSleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        mSleeper = sleeper;
        start();
    }

    @Override
    public void run() {
        try {
            mSleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Joiner thread join interrupt: " + e);
        }

        System.out.println(getName() + " join complete");
    }
}


public class Joining {

    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);

        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);
        grumpy.interrupt();
    }
}
