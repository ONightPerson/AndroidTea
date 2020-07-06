package com.liubz.androidtea.cherish.wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-30
 */
public class ThreadControl {
    private static Object sLock1 = new Object();
    private static Object sLock2 = new Object();

    static class Task1 implements Runnable {

        @Override
        public void run() {
            try {
                synchronized (sLock1) {
                    System.out.println("task#1 get lock#1");
                    synchronized (sLock2) {
                        System.out.println("task#1 get lock#2");

                        System.out.println("task#1 release lock#1");
                        sLock1.wait();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
    }

    static class Task2 implements Runnable {

        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(1);
                synchronized (sLock1) {
                    System.out.println("task#2 get lock#1");
                    synchronized (sLock2) {
                        System.out.println("task#2 get lock#2");

                        System.out.println("task#2 release lock#1");
                        sLock1.wait();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Task1());
        Thread thread2 = new Thread(new Task2());
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("my_main over");


    }


}
