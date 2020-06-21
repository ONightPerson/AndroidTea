package com.android.liubz.androidtea.java.concurrency;

/**
 * author: created by liubaozhu on 2020/6/20
 * email: liubaozhu@baidu.com
 */
public class ExceptionTask implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("exception task");
    }

    public static void main(String[] args) {
        try {
            new Thread(new ExceptionTask()).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
