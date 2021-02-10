package com.liubz.androidtea.cherish.thread;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liubaozhu on 2021/2/10
 */
public class CyclicBarrierTest {
    private static final int STUDENTS = 15;

    public static void main(String[] args) {
        waitAllReady();
    }

    /**
     * 班级活动，等待所有同学到齐出发
     */
    private static void waitAllReady() {
        final ExecutorService executor = Executors.newCachedThreadPool();
        final CyclicBarrier cb = new CyclicBarrier(STUDENTS, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有同学到齐，出发！");
                executor.shutdownNow();
            }
        });
        for (int i = 0; i < STUDENTS; i++) {
            Runnable student = new Runnable() {
                @Override
                public void run() {
                    Random random = new Random();
                    long waitTime = 1000L + random.nextInt(2000);
                    System.out.println("同学" + Thread.currentThread().getName() + "正在路上，还有"
                            + waitTime + " ms 到达");
                    try {
                        Thread.sleep(waitTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        cb.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            };
            executor.execute(student);
        }
    }
}
