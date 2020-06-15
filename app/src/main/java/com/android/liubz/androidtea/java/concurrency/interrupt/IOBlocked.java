package com.android.liubz.androidtea.java.concurrency.interrupt;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by liubaozhu on 2019-09-07
 */
class IOBlocked implements Runnable {
    private InputStream mIn;

    public IOBlocked(InputStream in) {
        mIn = in;
    }

    @Override
    public void run() {
        System.out.println("Waiting for read from System.in");
        try {
            mIn.read();
        } catch (IOException e) {
            System.out.println(e);
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupted from blocked I/O");
            } else {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}
