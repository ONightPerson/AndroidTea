package com.liubz.androidtea.concurrency.yield;

public class YieldTest implements Runnable {

    public YieldTest() {
        Thread t = new Thread(this);
        t.start();
    }

    public static void main(String[] args) {
        new YieldTest();
        new YieldTest();
        new YieldTest();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if ((i % 10) == 0) {
                System.out.println(Thread.currentThread() + " yield cpu...");
                Thread.yield();
            }
        }
        System.out.println(Thread.currentThread() + " is over");
    }


}
