package com.android.liubz.androidtea.java.concurrency.interrupt;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */

class BlockMutex {

    private Lock mLock = new ReentrantLock();

    public BlockMutex() {
        mLock.lock();
    }

    public void f() {
        try {
            mLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Blocking implements Runnable {

    BlockMutex mutex = new BlockMutex();

    @Override
    public void run() {
        System.out.println("start call f");
        mutex.f();
        System.out.println("call f over");
    }
}

public class Interrupting2 {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new Blocking());
        t.start();

        TimeUnit.SECONDS.sleep(3);
        t.interrupt();
    }
}
