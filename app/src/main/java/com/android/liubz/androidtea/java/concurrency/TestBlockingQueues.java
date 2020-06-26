package com.android.liubz.androidtea.java.concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * author: created by liubaozhu on 2020/6/26
 * email: liubaozhu@baidu.com
 */
public class TestBlockingQueues {

    static void getKey() {
        try {
            new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void getKey(String msg) {
        System.out.println(msg);
        getKey();
    }

    static void test(String msg, BlockingQueue<LiftOff> queue) {
        System.out.println(msg);
        LiftOffRunner runner = new LiftOffRunner(queue);
        Thread t = new Thread(runner);
        t.start();

        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }
        getKey("Press Enter (" + msg + ").");
        t.interrupt();
        System.out.println("Finish " + msg + " test");

    }

    public static void main(String[] args) {
        test("LinkedBlockingQueue", new LinkedBlockingDeque<>());
    }
}
