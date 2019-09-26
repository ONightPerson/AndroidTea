package com.android.liubz.androidtea.java.concurrent.checkinterrupt;

import java.util.concurrent.TimeUnit;

/**
 * Created by liubaozhu on 2019-09-07
 */
public class InterruptingIdiom {

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("usage: java InterruptingIdiom delay-in-ms");
            System.exit(1);
        }

        Thread t = new Thread(new BlockTask());
        t.start();
        TimeUnit.MILLISECONDS.sleep(Integer.valueOf(args[0]));
        t.interrupt();
    }
}
