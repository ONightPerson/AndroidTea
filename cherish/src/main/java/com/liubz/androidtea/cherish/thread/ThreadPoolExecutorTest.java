package com.liubz.androidtea.cherish.thread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

    private final ThreadPoolExecutor pool;

    private ThreadPoolExecutorTest() {
        //创建线程池
        pool = new ThreadPoolExecutor(4, 7, 60, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(4));
    }

    public static void main(String[] args) {
        ThreadPoolExecutorTest myClass = new ThreadPoolExecutorTest();
        for (int i = 0; i < 20; i++) {
            //提交任务
            try {
                myClass.pool.execute(new MyRunnable(myClass));
            } catch (Exception e) {

            }
        }
        myClass.pool.shutdown();
    }

    private String getCount() {
        return pool.getCorePoolSize() + "-" + pool.getActiveCount() + "-" + pool
                .getMaximumPoolSize();
    }

    private static class MyRunnable implements Runnable {
        ThreadPoolExecutorTest myClass;

        MyRunnable(ThreadPoolExecutorTest myClass) {
            this.myClass = myClass;
        }

        @Override
        public void run() {
            System.out.println(
                    "thread name:" + Thread.currentThread().getName() + " start " + myClass
                            .getCount());
            try {
                //模拟耗时任务
                Thread.sleep(3000L);
                System.out.println(
                        "thread name:" + Thread.currentThread().getName() + " end " + myClass
                                .getCount());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
