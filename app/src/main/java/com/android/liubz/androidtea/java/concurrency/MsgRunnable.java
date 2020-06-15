package com.android.liubz.androidtea.java.concurrency;

/**
 * Created by liubaozhu on 2019-08-06
 */
public class MsgRunnable implements Runnable {

    private String mMsg;

    public MsgRunnable(String msg) {
        mMsg = msg;
        System.out.println(msg + " is coming!");
    }

    @Override
    public void run() {
        int i = 3;
        while (i-- > 0) {
            System.out.println(mMsg + " running " + i);
            Thread.yield();
        }
        System.out.println(mMsg + " run over.");
    }

    public static void main(String[] args) {
        new Thread(new MsgRunnable("Baby Machine")).start();
//        new Thread(new MsgRunnable("Adult Machine")).start();
//        new Thread(new MsgRunnable("Girls' Machine")).start();

    }
}
