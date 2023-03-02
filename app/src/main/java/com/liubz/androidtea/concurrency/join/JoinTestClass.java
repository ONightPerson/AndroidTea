package com.liubz.androidtea.concurrency.join;

import com.liubz.androidtea.utils.ThreadUtils;

public class JoinTestClass {
    public static void main(String[] args) {

        testJoin();
        testInterruptJoiningThread();
    }

    public static void testJoin() {
        Thread threadOne = new Thread(new Task(5000), "ThreadOne");
        Thread threadTwo = new Thread(new Task(1000), "ThreadTwo");
        // start
        threadOne.start();
        threadTwo.start();
        ThreadUtils.join(threadOne);
        ThreadUtils.join(threadTwo);
    }

    public static void testInterruptJoiningThread() {
        final Thread mainThread = Thread.currentThread();
        final Thread threadThree = new Thread(() -> {
            ThreadUtils.sleep(1000);
            mainThread.interrupt();
        });
        threadThree.start();
        ThreadUtils.join(threadThree);
    }

    static class Task implements Runnable {
        private long timeout;

        public Task(long timeout) {
            this.timeout = timeout;
        }

        @Override
        public void run() {
            ThreadUtils.sleep(timeout);
            System.out.println("Task" + Thread.currentThread().getName() + " end");
        }
    }
}
