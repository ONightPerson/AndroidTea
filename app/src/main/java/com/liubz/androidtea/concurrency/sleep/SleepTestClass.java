package com.liubz.androidtea.concurrency.sleep;

import com.liubz.androidtea.utils.ThreadUtils;

public class SleepTestClass {
    public static void main(String[] args) {

        testSleep();
    }

    public static void testSleep() {
        Thread threadOne = new Thread(new Task(5000), "ThreadOne");
        Thread threadTwo = new Thread(new Task(1000), "ThreadTwo");
        // start
        threadOne.start();
        threadTwo.start();
//        ThreadUtils.join(threadOne);
//        ThreadUtils.join(threadTwo);
        ThreadUtils.sleep(2000);
        threadOne.interrupt();
    }

    static class Task implements Runnable {
        private long timeout;

        public Task(long timeout) {
            this.timeout = timeout;
        }

        @Override
        public void run() {

            ThreadUtils.sleep(timeout);
            System.out.println("Task " + Thread.currentThread().getName() + " end");
        }
    }
}
