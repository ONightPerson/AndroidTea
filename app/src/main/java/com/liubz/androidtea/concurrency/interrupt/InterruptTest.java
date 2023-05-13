package com.liubz.androidtea.concurrency.interrupt;

import com.liubz.androidtea.utils.ThreadUtils;

public class InterruptTest {
    private static Object lock = new Object();

    static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    System.out.println("start waiting");
                    lock.wait();
                    System.out.println("waiting end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

//        testInterruptWaitingThread();
//        testInterruptJoinThread();
        testInterruptNormalThread();
    }

    private static void testInterruptSleepingThread() {
        Thread sleepThread = new Thread(() -> ThreadUtils.sleep(3000));
        sleepThread.start();
        ThreadUtils.sleep(1000);
        interruptThread(sleepThread);
    }

    private static void testInterruptWaitingThread() {
        Thread waitingThread = new Thread(new Task());
        waitingThread.start();
        ThreadUtils.sleep(1000);
        interruptThread(waitingThread);
    }

    private static void testInterruptJoinThread() {
        Thread sleepThread1 = new Thread(() -> ThreadUtils.sleep(3000));
        Thread sleepThread2 = new Thread(() -> {
            System.out.println(Thread.currentThread() + " start");
            ThreadUtils.join(sleepThread1);
            System.out.println(Thread.currentThread() + " end");
        });
        Thread sleepThread3 = new Thread(() -> {
            ThreadUtils.sleep(1000);
            sleepThread2.interrupt();
        });
        sleepThread1.start();
        sleepThread2.start();
        sleepThread3.start();
    }

    private static void testInterruptNormalThread() {
        Thread t = new Thread(() -> {
            while (!Thread.interrupted()) {
                for (int i = 0; i < 10000; i++) {
                }
            }
            System.out.println(Thread.currentThread().getName() + " has been interrupted and now interrupt flag is: " + Thread.currentThread().isInterrupted());

        });

        t.start();
        t.interrupt();

    }

    public static void interruptThread(Thread t) {
        if (t == null) {
            return;
        }
        t.interrupt();
    }


}
