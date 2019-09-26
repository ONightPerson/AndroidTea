package com.android.liubz.androidtea.java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liubaozhu on 2019-08-18
 */
public class EvenChecker implements Runnable {
    private IntGenerator mGenerator;
    private final int mId;

    public EvenChecker(IntGenerator g, int id) {
        mGenerator = g;
        mId = id;
    }

    @Override
    public void run() {
        while (!mGenerator.isCanceled()) {
            int val = mGenerator.next();
//            System.out.println("[" + mId + "]current value: " + val);
            if (val % 2 != 0) {
                System.out.println(val + " is not even");
                mGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator gp, int count) {
        System.out.println("Press CRL+C to exit");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(gp, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator gp) {
        test(gp, 10);
    }
}
