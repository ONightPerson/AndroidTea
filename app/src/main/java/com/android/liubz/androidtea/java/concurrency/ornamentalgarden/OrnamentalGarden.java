package com.android.liubz.androidtea.java.concurrency.ornamentalgarden;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-07
 */
public class OrnamentalGarden {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }

        TimeUnit.SECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();

        if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
            System.out.println("Some Task were not terminated");
        }

        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Some of Entrances: " + Entrance.sumEntrances());
    }
}
