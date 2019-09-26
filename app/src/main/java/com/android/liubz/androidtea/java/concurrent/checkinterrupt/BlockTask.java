package com.android.liubz.androidtea.java.concurrent.checkinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-07
 */
class BlockTask implements Runnable {
    private volatile double d = 0.0;
    private long mCount = 0;

    @Override
    public void run() {
        while (true) {
            System.out.println("loop#" + ++mCount);
            NeedCleanup n2 = new NeedCleanup(2);
            try {
                System.out.println("Calculating");
                for (int i = 0; i < 250000; i++) {
                    d = d + (Math.PI + Math.E) / d;
                }
            } finally {
                n2.cleanup();
            }
        }
    }

    class NeedCleanup {
        private final int id;

        public NeedCleanup(int id) {
            this.id = id;
            System.out.println("Need cleaning up  " + id);
        }

        public void cleanup() {
            System.out.println("Cleaning up " + id);
        }
    }
}
