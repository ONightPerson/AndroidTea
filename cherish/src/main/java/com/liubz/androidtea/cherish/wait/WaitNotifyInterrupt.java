package com.liubz.androidtea.cherish.wait;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-30
 */
public class WaitNotifyInterrupt {

    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("-----begin-----");
                    synchronized (obj) {
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        TimeUnit.SECONDS.sleep(1);

        System.out.println("-----begin interrupt threadA-----");
        threadA.interrupt();
        System.out.println("-----end interrupt threadA-----");
    }
}
