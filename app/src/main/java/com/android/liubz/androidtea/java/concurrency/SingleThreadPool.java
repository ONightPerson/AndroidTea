package com.android.liubz.androidtea.java.concurrency;

/**
 * Created by liubaozhu on 2019-08-10
 */
public class SingleThreadPool {

    public static void main(String[] args) {
//        ExecutorService exec = Executors.newSingleThreadExecutor();
//        for (int i = 0; i < 5; i++) {
//            exec.execute(new LiftOffRunnable());
//        }
//        exec.shutdown();

        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);

        Integer i3 = 1000;
        Integer i4 = 1000;
        System.out.println(i3 == i4);
    }
}
