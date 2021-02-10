package com.liubz.androidtea.cherish.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liubaozhu on 2021/2/10
 */
public class CountDownLatchTest {

    private static final int JUDGE_NUM = 1;
    private static final int SPORTSMAN_NUM = 5;

    public static void main(String[] args) {
        // 裁判个数，运动员就绪后需等待裁判鸣哨才开始比赛
        CountDownLatch whistleLatch = new CountDownLatch(JUDGE_NUM);
        // 运动员个数，需等待所有运动员跑完才宣布结果
        CountDownLatch finishLatch = new CountDownLatch(SPORTSMAN_NUM);
        ExecutorService exec = Executors.newCachedThreadPool();
        waitWhistle(exec, whistleLatch, finishLatch);

        // 主线程执行裁判动作
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println("裁判" + threadName + "在来的路上");
            Thread.sleep(500L);
            System.out.println("裁判" + threadName + "就绪");
            whistleLatch.countDown();
            System.out.println("裁判" + threadName + "鸣哨");
            finishLatch.await();
            System.out.println("比赛全部结束，公布运动员成绩");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class Sportsman implements Runnable {

        private final CountDownLatch whistleLatch;
        private final CountDownLatch finishLatch;

        public Sportsman(CountDownLatch whistleLatch, CountDownLatch finishLatch) {
            this.whistleLatch = whistleLatch;
            this.finishLatch = finishLatch;
        }

        @Override
        public void run() {
            try {
                String threadName = Thread.currentThread().getName();
                System.out.println("运动员" + threadName + "已准备就绪");
                whistleLatch.await();
                System.out.println("运动员" + threadName + "开始比赛");
                Thread.sleep(1000 + new Random().nextInt(2000));
                System.out.println("运动员" + threadName + "完成比赛");
                finishLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 运动员准备就绪，等待鸣哨
     */
    private static void waitWhistle(ExecutorService exec, CountDownLatch whistleLatch,
                                    CountDownLatch finishLatch) {
        for (int i = 0; i < SPORTSMAN_NUM; i++) {
            exec.execute(new Sportsman(whistleLatch, finishLatch));
        }
    }
}
