package com.android.liubz.androidtea.java.concurrent;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

/**
 * Created by liubaozhu on 2019-11-04
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class AtomicLongTest {

    private static LongAccumulator sCounter = new LongAccumulator(new LongBinaryOperator() {
        @Override
        public long applyAsLong(long left, long right) {
            return left * right;
        }
    }, 10);
    private static int[] sArrayOne = new int[] {0, 1, 2, 3, 9, 9, 0, 1, 3, 0};
    private static int[] sArrayTwo = new int[] {0, 1, 2, 3, 9, 9, 10, 1, 3, 0};

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new ArrayOneCountTask());
        Thread thread2 = new Thread(new ArrayTwoCountTask());

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println("sCounter value: " + sCounter.intValue());
    }

    static class ArrayOneCountTask implements Runnable {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            int size = sArrayOne.length;
            for (int i = 0; i < size; i++) {
                if (sArrayOne[i] == 0) {
                    sCounter.accumulate(1);
                }
            }
        }
    }

    static class ArrayTwoCountTask implements Runnable {

        @RequiresApi(api = Build.VERSION_CODES.N)
        @Override
        public void run() {
            int size = sArrayTwo.length;
            for (int i = 0; i < size; i++) {
                if (sArrayTwo[i] == 0) {
                    sCounter.accumulate(1);
                }
            }
        }
    }
}
