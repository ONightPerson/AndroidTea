package com.android.liubz.androidtea.java.concurrency;

/**
 * Created by liubaozhu on 2019-08-25
 */
public class Atomicity {

    int i;
    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }

    void f3() {
        i = 2;
    }

    int f4() {
        return i;
    }
}
