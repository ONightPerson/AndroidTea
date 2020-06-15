package com.android.liubz.androidtea.java.concurrency;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by liubaozhu on 2019-11-03
 */
public class RandomTest {
    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }

    }
}
