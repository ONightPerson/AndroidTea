package com.android.liubz.androidtea.java.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/26
 * email: liubaozhu@baidu.com
 */

class Restaurant {

    private Meal mMeal;
    private Plate mPlate;

    private Cook mCooking;
    private Delivery mDelivering;
    private Wash mWashing;

    private ExecutorService mTaskExec = Executors.newFixedThreadPool(3);

    public void startWork() {
        startCooking();
        startDelivering();
        startWashing();
    }

    public void stopWork() {
        mTaskExec.shutdownNow();
    }

    private void startCooking() {
        mCooking = new Cook();
        mTaskExec.execute(mCooking);
    }

    private void startDelivering() {
        mDelivering = new Delivery();
        mTaskExec.execute(mDelivering);
    }

    private void startWashing() {
        mWashing = new Wash();
        mTaskExec.execute(mWashing);
    }

    /**
     * 餐类，用于厨师和送餐员之间同步
     */
    static class Meal {

    }

    /**
     * 餐盘类，用于送餐员和洗碗工之前同步
     */
    static class Plate {

    }

    class Cook implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (mMeal != null) {
                            wait();
                        }
                    }

                    System.out.println("start cooking");
                    TimeUnit.MILLISECONDS.sleep(300);
                    System.out.println("cook finish");

                    synchronized (mDelivering) {
                        mMeal = new Meal();
                        mDelivering.notifyAll();
                    }

                }
            } catch (InterruptedException e) {
                System.out.println("Cook task interrupt: " + e);
            }
        }
    }

    class Delivery implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {

                    synchronized (this) {
                        while (mMeal == null) {
                            wait();
                        }
                    }
                    System.out.println("start delivering");
                    TimeUnit.MILLISECONDS.sleep(200);
                    System.out.println("delivery finish");
                    // 送完餐，通知厨师
                    synchronized (mCooking) {
                        mMeal = null;
                        mCooking.notifyAll();
                        System.out.println("notify Cook");
                    }

                    // 上完菜，通知洗碗工清理
                    synchronized (mWashing) {
                        mPlate = new Plate();
                        mWashing.notifyAll();
                        System.out.println("notify DishWasher");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Delivery task interrupt: " + e);
            }
        }
    }

    class Wash implements Runnable {

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (mPlate == null) {
                            wait();
                        }
                    }

                    System.out.println("start washing");
                    TimeUnit.MILLISECONDS.sleep(100);
                    System.out.println("wash finish");

                    // 清理完，同步送餐员
                    synchronized (mDelivering) {
                        mPlate = null;
                        mDelivering.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("Wash task interrupt: " + e);
            }
        }
    }

}

public class Exercise26 {

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.startWork();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        restaurant.stopWork();

    }


}
