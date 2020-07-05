package com.android.liubz.androidtea.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/27
 * email: liubaozhu@baidu.com
 */
class DelayedTask implements Runnable, Delayed {

    private static int sCounter = 0;
    private final int mId = sCounter++;
    private long mDeltaTime;
    private long mTriggerTime;

    private static List<DelayedTask> mTaskList = new ArrayList<>();

    public DelayedTask(long delayedInMilliSeconds) {
        mDeltaTime = delayedInMilliSeconds;
        mTriggerTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(mDeltaTime,
                TimeUnit.MILLISECONDS);
        mTaskList.add(this);
    }

    @Override
    public void run() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("DelayedTask{%1$d} after delayed %2$-4d ms start work.", mId, mDeltaTime);
    }

    public String summary() {
        return "(" + mId + ":" + mDeltaTime + ")";
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(mTriggerTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        DelayedTask task = (DelayedTask) o;
        if (mTriggerTime > task.mTriggerTime) {
            return 1;
        } else if (mTriggerTime < task.mTriggerTime) {
            return -1;
        } else {
            return 0;
        }
    }

    public static class EndSentinel extends DelayedTask {

        private ExecutorService mExec;

        public EndSentinel(long delay, ExecutorService e) {
            super(delay);
            mExec = e;
        }

        @Override
        public void run() {
            for (DelayedTask task : mTaskList) {
                System.out.println(task.summary());
            }
            System.out.println(this + " calling shutdown");
            mExec.shutdownNow();
        }
    }
}

class DelayedTaskConsumer implements Runnable {

    private DelayQueue<DelayedTask> mTaskQueue;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        mTaskQueue = q;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                mTaskQueue.take().run();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished DelayedTaskConsumer");
    }
}

public class DelayedTaskDemo {

    public static void main(String[] args) {
        Random random = new Random();
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<>();
        for (int i = 0; i < 20; i++) {
            queue.add(new DelayedTask(random.nextInt(5000)));
        }
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
