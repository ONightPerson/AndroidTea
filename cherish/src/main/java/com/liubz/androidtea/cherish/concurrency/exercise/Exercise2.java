package com.liubz.androidtea.cherish.concurrency.exercise;

import com.android.liubz.androidtea.java.concurrency.Fibonacci;

/**
 * author: created by liubaozhu on 2020/6/10
 * email: liubaozhu@baidu.com
 */
public class Exercise2 {
    static class Task implements Runnable {
        private int mNum;
        public Task(int n) {
            mNum = n;
        }

        @Override
        public void run() {
            Fibonacci fi = new Fibonacci();
            for (int i = 0; i< mNum; i++) {
                System.out.print(fi.next() + " ");
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Task(15)).start();
        }
    }
}
