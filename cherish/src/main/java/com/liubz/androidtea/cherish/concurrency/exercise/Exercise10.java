package com.liubz.androidtea.cherish.concurrency.exercise;

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
public class Exercise10 {

    public static void main(String[] args) {
        List<Future<Integer>> result = new ArrayList<>();
        ThreadMethod method = new ThreadMethod();
        for (int i = 0; i < 5; i++) {
            result.add(method.runTask(10));
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
        method.shutDown();
    }
}

class Task implements Callable<Integer> {
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

class ThreadMethod {

    private ExecutorService mExec;

    public ThreadMethod() {
        mExec = Executors.newFixedThreadPool(10);
    }

    public Future<Integer> runTask(int n) {
        return mExec.submit(new Task(n));
    }

    public void shutDown() {
        if (mExec != null) {
            mExec.shutdown();
        }
    }
}
