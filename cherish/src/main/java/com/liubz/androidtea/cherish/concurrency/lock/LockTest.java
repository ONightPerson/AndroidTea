package com.liubz.androidtea.cherish.concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-11-04
 */
public class LockTest {

    public static void main(String[] args) throws InterruptedException {




    }

    private static void print() {
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();

        lock.lock();  // 上锁
        try {
            System.out.println("begin waiting");
            condition.await();
            System.out.println("finish waiting");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        lock.lock();

    }
}
