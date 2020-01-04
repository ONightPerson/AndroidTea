package com.android.liubz.androidtea.java.concurrent.reentrant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-07
 */
public class Interrupting2 {

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<?> f = exec.submit(new ReentrantBlocked());
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Issuing first.interrupt()");
        f.cancel(true);
    }
}
