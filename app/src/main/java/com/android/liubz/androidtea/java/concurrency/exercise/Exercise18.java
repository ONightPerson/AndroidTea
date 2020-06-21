package com.android.liubz.androidtea.java.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */

class Eat {

    public void eatSlowly() throws InterruptedException {
        out.println("start eating");
        TimeUnit.SECONDS.sleep(3);
    }
}

class EatTask implements Runnable {

    private Eat eat;

    public EatTask(Eat eat) {
        this.eat = eat;
    }

    @Override
    public void run() {
        while (true) {
            try {
                eat.eatSlowly();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Exercise18 {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Eat eat = new Eat();
        exec.execute(new EatTask(eat));
        exec.shutdownNow();
    }
}
