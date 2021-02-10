package com.liubz.androidtea.cherish.thread;

/**
 * Created by liubaozhu on 2021/2/9
 */
public class InterruptTest {

    public static void main(String[] args) {
        interruptJoinThread();
    }

    private static void interruptSleepThread() {
        Thread task = startCalTask();
        endCalTask(task);
    }

    private static void interruptJoinThread() {
        Thread taskOne = new Thread(new Runnable() {
            @Override
            public void run() {
               while (true) {

               }
            }
        });
        final Thread mainThread = Thread.currentThread();
        Thread taskTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mainThread.interrupt();
            }
        });
        taskOne.start();
        taskTwo.start();

        try {
            taskOne.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static Thread startCalTask() {
        Thread calTask = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(5000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        calTask.start();
        return calTask;
    }

    private static void endCalTask(final Thread task) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                task.interrupt();
            }
        }).start();
    }
}
