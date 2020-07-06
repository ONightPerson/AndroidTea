package com.liubz.androidtea.cherish.concurrency.exercise;

import com.android.liubz.androidtea.java.concurrency.Fibonacci;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: created by liubaozhu on 2020/6/10
 * email: liubaozhu@baidu.com
 */
public class Exercise4 {
    static class Task implements Runnable {
        private int mNum;
        public Task(int n) {
            mNum = n;
        }

        @Override
        public void run() {
            Fibonacci fi = new Fibonacci();
            for (int i = 0; i< mNum; i++) {
                System.out.print(fi.next() + " ");
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task(15));
        }
        exec.shutdown();
    }
}
