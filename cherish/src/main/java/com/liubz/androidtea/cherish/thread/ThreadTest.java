package com.liubz.androidtea.cherish.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/15 12:54 PM
 */
public class ThreadTest {

    public static class CallerTask implements Callable<String> {
        @Override
        public String call() throws Exception {
            return "Hello";
        }
    }

    private static Object sharedVar = 0;

    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        // 启动线程
//        new Thread(futureTask).start();
//        try {
//            String result = futureTask.get();
//            System.out.println("result: " + result);
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (sharedVar) {
                    try {
                        sharedVar.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "firstWait").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sharedVar.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "tryToWait").start();
    }
}
