package com.android.liubz.androidtea.java.concurrency.interrupt;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */

class NeedsCleanup {

    private int id;

    public NeedsCleanup(int id) {
        this.id = id;
    }

    public void cleanup() {
        out.println("NeedCleanup " + id + " clean up.");
    }
}

class BlockTask implements Runnable {

    @Override
    public void run() {

        try {
            while (!Thread.interrupted()) {
                NeedsCleanup nc1 = new NeedsCleanup(1);
                try {
                    out.println("start sleeping");
                    TimeUnit.SECONDS.sleep(1);

                    NeedsCleanup nc2 = new NeedsCleanup(2);
                    out.println("start do time-consuming operation");
                    try {
                        double d = 0;
                        for (int i = 0; i < 250000000; i++) {
                            d += (Math.PI + Math.E) / d;
                        }
                    } finally {
                        nc2.cleanup();
                    }
                } finally {
                    nc1.cleanup();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

public class InterruptingIdiom {

    public static void main(String[] args) throws InterruptedException {

        if (args.length < 1) {
            out.println("need pass param sleep time in ms");
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new BlockTask());

        TimeUnit.MILLISECONDS.sleep(Integer.valueOf(args[0]));
        exec.shutdownNow();

    }
}
