package com.android.liubz.androidtea.java.concurrency.coordinate;

/**
 * Created by liubaozhu on 2019-09-09
 */
class Blocker {

    synchronized void waitingForCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.print(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}
