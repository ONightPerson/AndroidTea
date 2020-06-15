package com.android.liubz.androidtea.java.concurrency.exercise;

import com.android.liubz.androidtea.java.concurrency.Fibonacci;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * author: created by liubaozhu on 2020/6/10
 * email: liubaozhu@baidu.com
 */
public class Exercise5 {
    static class Task implements Callable<Integer> {
        private int mNum;
        public Task(int n) {
            mNum = n;
        }

        @Override
        public Integer call() throws Exception {
            Fibonacci fi = new Fibonacci();
            int sum = 0;
            for (int i = 0; i< mNum; i++) {
                sum += fi.next();
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        List<Future<Integer>> result = new ArrayList<>();
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            result.add(exec.submit(new Task(22)));
        }

        for (Future<Integer> fi : result) {
            try {
                System.out.println(fi.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        exec.shutdown();
    }
}
