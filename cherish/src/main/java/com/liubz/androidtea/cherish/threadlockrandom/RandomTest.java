package com.liubz.androidtea.cherish.threadlockrandom;

import java.util.Random;

/**
 * Created by liubaozhu on 2019-10-05
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            System.out.println("random " + i + ": " + random.nextInt(5));
        }
    }
}
