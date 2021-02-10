package com.liubz.androidtea.cherish.thread;

/**
 * Created by liubaozhu on 2021/2/8
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        final CalculatorTask task = new CalculatorTask(false);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    task.doSubTask();
                }
            }
        }).start();
        for (int i = 0; i < 5; i++) {
            task.doMainTask();
        }
    }

}

class CalculatorTask {
    // 是否为子线程任务
    private boolean isSub;

    public CalculatorTask(boolean isSub) {
        this.isSub = isSub;
    }

    public synchronized void doSubTask() {
        while (!isSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++) {
            System.out.println("do sub thread task: " + i);
        }
        isSub = false;
        this.notify();
    }

    public synchronized void doMainTask() {
        while (isSub) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 2; i++) {
            System.out.println("do main thread task: " + i);
        }
        isSub = true;
        this.notify();
    }

}
