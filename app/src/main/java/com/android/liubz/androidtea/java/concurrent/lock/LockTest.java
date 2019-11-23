package com.android.liubz.androidtea.java.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by liubaozhu on 2019-11-04
 */
public class LockTest {

    public void testPark() {
        LockSupport.park(this);
    }
    public static void main(String[] args) throws InterruptedException {

        LockTest test = new LockTest();
        test.testPark();
    }
}
