package com.android.liubz.androidtea.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/27
 * email: liubaozhu@baidu.com
 */
class Horse implements Runnable {
    private static int sCounter = 0;
    private final int mId = sCounter++;
    private int strides;
    private static Random mRandom = new Random();

    private CyclicBarrier mCyclicBarrier;

    public Horse(CyclicBarrier barrier) {
        mCyclicBarrier = barrier;
    }

    public synchronized int getStrides() {
        return strides;
    }

    @Override
    public String toString() {
        return "Horse{" + mId + "}";
    }

    public String tracks() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < getStrides(); i++) {
            s.append("*");
        }
        s.append(mId);
        return s.toString();
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    strides += mRandom.nextInt(3);
                }
                mCyclicBarrier.await();
            }

        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class HorseRace {

    private static final int HORSE_RACE_FINISH_LINE = 75;
    private List<Horse> mHorses = new ArrayList<>();
    private ExecutorService exec = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        int nHorse = 7;
        long pause = 200;
        HorseRace race = new HorseRace();
        race.startRace(nHorse, pause);

    }

    public void startRace(int horseNum, long pause) {
        CyclicBarrier barrier = new CyclicBarrier(horseNum, new BarrierAction(pause));
        for (int i = 0; i < horseNum; i++) {
            Horse horse = new Horse(barrier);
            mHorses.add(horse);
            exec.execute(horse);
        }
    }

    class BarrierAction implements Runnable {

        private long mPause;

        public BarrierAction(long pause) {
            mPause = pause;
        }

        @Override
        public void run() {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < HORSE_RACE_FINISH_LINE; i++) {
                s.append("=");
            }
            System.out.print(s);

            for (Horse horse : mHorses) {
                System.out.print(horse.tracks());
            }
            for (Horse horse : mHorses) {
                if (horse.getStrides() >= HORSE_RACE_FINISH_LINE) {
                    System.out.println(horse + " won");
                    exec.shutdownNow();
                    return;
                }
            }

            try {
                TimeUnit.MILLISECONDS.sleep(mPause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
