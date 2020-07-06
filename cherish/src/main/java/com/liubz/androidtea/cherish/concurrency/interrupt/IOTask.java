package com.liubz.androidtea.cherish.concurrency.interrupt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by liubaozhu on 2019-09-07
 */
class IOTask implements Runnable {
    private InputStream mIn;

    public IOTask(InputStream in) {
        mIn = in;
    }

    @Override
    public void run() {
        System.out.println("Waiting for read from input stream");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(mIn));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("read line: " + line);
            }
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
