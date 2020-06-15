package com.android.liubz.androidtea.java.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liubaozhu on 2019-08-06
 */
public class Exercise3 {

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
        ExecutorService exec = Executors.newSingleThreadExecutor();
        int count = 10;
        while (count-- > 0) {
            exec.execute(new Task());
        }
        exec.shutdown();
    }
}
