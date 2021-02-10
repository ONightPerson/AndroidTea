package com.liubz.androidtea.cherish.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by liubaozhu on 2021/2/9
 */
public class SemaphoreTest {
    private static final int PERMITS = 5;

    public static void main(String[] args) {
        buyTickets();
    }

    private static void buyTickets() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(PERMITS, true);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new BuyTicketsTask(semaphore));
        }
    }

    static class BuyTicketsTask implements Runnable {
        private final Semaphore semaphore;

        public BuyTicketsTask(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Random random = new Random();
                System.out.println(Thread.currentThread().getName() + "正在买票，当前正在买票的人数为："
                        + (PERMITS - semaphore.availablePermits()));
                long consumeTime = 1000L + random.nextInt(2000);
                Thread.sleep(consumeTime);
                System.out.println(Thread.currentThread().getName() + "已买完票");
                semaphore.release();
                System.out.println("当前正在买票的人数为：" + (PERMITS - semaphore.availablePermits()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
