package com.liubz.androidtea.cherish.concurrency.exercise;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-08-06
 */
public class Exercise1 {

    static class Task implements Runnable {
        private static int taskCount = 0;
        private final int taskId = taskCount++;

        public Task() {
            System.out.println("Task" + taskId + " Init");
        }

        @Override
        public void run() {
            System.out.println("Task" + taskId + " running");
            Thread.yield();
            System.out.println("Task" + taskId + " running");
            Thread.yield();
            System.out.println("Task" + taskId + " running");
            Thread.yield();

            System.out.println("Task" + taskId + " finished");
        }
    }



    public static void main(String[] args) {
        int count = 10;
        while (count-- > 0) {
            new Thread(new Task()).start();
        }
    }
}
