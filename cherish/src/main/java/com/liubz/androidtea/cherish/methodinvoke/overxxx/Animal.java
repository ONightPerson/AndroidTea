package com.liubz.androidtea.cherish.methodinvoke.overxxx;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 5/15/24 7:53 PM
 */
public class Animal {

    public void sleep() {
        System.out.println("sleep");
    }

    public void sleep(long timeMillis) {
        System.out.println("sleep " + timeMillis + " milliseconds");
    }

    public static void sleep(boolean isDay) {
        System.out.println("sleep " + (isDay ? "during the day" : "at night"));
    }

    public final void breathe() {
        System.out.println("breathe");
    }
}
