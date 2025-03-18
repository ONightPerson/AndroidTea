package com.liubz.androidtea.cherish.concurrent.lock;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {

    public void testPark() {
        LockSupport.park(this);
    }
    public static void main(String[] args) {
        LockSupportDemo demo = new LockSupportDemo();
        demo.testPark();
    }
}
