package com.android.liubz.androidtea.java.join;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-30
 */
public class JoinTest {


    public static void main(String[] args) {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadA starts to run");
                while (true) {

                }
            }
        });

        Thread threadMain = Thread.currentThread();

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("threadB starts to run");
                try {
                    TimeUnit.SECONDS.sleep(1);
                    threadMain.interrupt();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();

        try {
            threadA.join();
        } catch (InterruptedException e) {
            System.out.println("main thread: " + e);
        }

    }
}
