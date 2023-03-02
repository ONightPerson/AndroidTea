package com.liubz.androidtea.concurrency.join;

import com.liubz.androidtea.utils.ThreadUtils;

public class JoinTestClass {
    public static void main(String[] args) {

        Thread threadOne = new Thread(new Task(), "ThreadOne");
        Thread threadTwo = new Thread(new Task(), "ThreadTwo");

        // start
        threadOne.start();
        threadTwo.start();

        System.out.println("wait all thread over");

        ThreadUtils.join(threadOne);
        ThreadUtils.join(threadTwo);
        System.out.println("all thread over");
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            ThreadUtils.sleep(1000);
            System.out.println("Task" + Thread.currentThread().getName() + " end");
        }
    }
}
