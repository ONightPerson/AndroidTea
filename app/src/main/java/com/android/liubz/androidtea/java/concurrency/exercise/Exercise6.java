package com.android.liubz.androidtea.java.concurrency.exercise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/10
 * email: liubaozhu@baidu.com
 */
public class Exercise6 implements Runnable {

    @Override
    public void run() {
        try {
            Random random = new Random();
            int randomNum = random.nextInt(10) + 1; // 睡眠 1 至 10s
            System.out.println("睡眠" + randomNum + "秒");
            TimeUnit.MICROSECONDS.sleep(randomNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            exec.execute(new Exercise6());
        }
        exec.shutdown();
    }
}
