package com.android.liubz.androidtea.java.concurrency;

import com.android.liubz.androidtea.java.concurrency.exercise.Exercise9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liubaozhu on 2019-08-10
 */
public class CachedThreadPool {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(6, new Exercise9.SimplePrioritiesFactory(Thread.MIN_PRIORITY));
        for (int i = 0; i < 5; i++) {
            exec.execute(new Exercise9());
        }
        exec.shutdown();
    }
}
