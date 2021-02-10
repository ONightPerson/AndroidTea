package com.liubz.androidtea.cherish.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * author: created by liubaozhu on 2021/2/10
 * email: liubaozhu@baidu.com
 */
public class FutureTaskTest {

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new SayHiTask());
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(futureTask);


        try {
            String result = futureTask.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

    static class SayHiTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Hello";
        }
    }
}
