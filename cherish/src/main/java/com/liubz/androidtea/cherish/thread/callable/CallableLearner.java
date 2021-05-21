package com.liubz.androidtea.cherish.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * author: created by liubaozhu on 2021/5/16
 * email: liubaozhu@baidu.com
 */
public class CallableLearner {

    public static void main(String[] args) {
        MyCallable callable = new MyCallable();
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(callable);

        try {
            System.out.println("try get");
            long startTime = System.currentTimeMillis();
            System.out.println(future.get());
            System.out.println("consume time: " + (System.currentTimeMillis() - startTime));
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(1000L);
            return "hello";
        }
    }
}
