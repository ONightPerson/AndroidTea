package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-08-25
 */
public class SerialNumberChecker {

    private static final int SIZE = 10;
    private static CircularSet sSerials = new CircularSet(1000);
    private static ExecutorService sExec = Executors.newCachedThreadPool();

    static class SerialChecker implements Runnable {

        @Override
        public void run() {
            while (true) {
                int serial = SerialNumberGenerator.nextSerialNumber();
                if (sSerials.contains(serial)) {
                    System.out.println("Duplicate: " + serial);
                    System.exit(0);
                }
                sSerials.add(serial);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < SIZE; i++) {
            sExec.execute(new SerialChecker());
        }
        // Stop after n seconds if there is an argument
        if (args.length > 0) {
            TimeUnit.SECONDS.sleep(new Integer(args[0]));
            System.out.println("No duplicate detected");
            System.exit(0);
        }
    }
}
