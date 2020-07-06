package com.liubz.androidtea.cherish.concurrency.pairtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liubaozhu on 2019-08-28
 */
public class CriticalSection {

    static void testApproaches(PairSafeManager pm1, PairSafeManager pm2) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PairManipulator manipulator1 = new PairManipulator(pm1);
        PairManipulator manipulator2 = new PairManipulator(pm2);
        PairChecker checker1 = new PairChecker(pm1);
        PairChecker checker2 = new PairChecker(pm2);

        exec.execute(manipulator1);
        exec.execute(manipulator2);
        exec.execute(checker1);
        exec.execute(checker2);

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            System.out.println("Sleep interrupted");
        }

        System.out.println("manipulator1: " + manipulator1 + "\nmanipulator2: " + manipulator2);
        System.exit(0);
    }

    public static void main(String[] args) {
//        PairSafeManager pm1 = new PairManager1();
//        PairSafeManager pm2 = new PairManager2();
        PairSafeManager pm1 = new ExplicitPairManager1();
        PairSafeManager pm2 = new ExplicitPairManager2();
        testApproaches(pm1, pm2);
    }
}
