package com.android.liubz.androidtea.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * author: created by liubaozhu on 2020/6/27
 * email: liubaozhu@baidu.com
 */
class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

    private static int sCounter = 0;
    private final int mId = sCounter++;
    private static Random sRandom = new Random();

    private int mPriority;

    private static List<PrioritizedTask> mTaskList = new ArrayList<>();

    public PrioritizedTask(int priority) {
        mPriority = priority;
        mTaskList.add(this);
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(sRandom.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("PrioritizedTask{%1$d}'s priority is %2$-4d.", mId, mPriority);
    }

    public String summary() {
        return "(" + mId + ":" + mPriority + ")";
    }


    @Override
    public int compareTo(PrioritizedTask p) {
        if (mPriority < p.mPriority) {
            return 1;
        } else if (mPriority > p.mPriority) {
            return -1;
        } else {
            return 0;
        }
    }

    public static class EndSentinel extends PrioritizedTask {

        private ExecutorService mExec;

        public EndSentinel(int priority, ExecutorService e) {
            super(priority);
            mExec = e;
        }

        @Override
        public void run() {
            for (PrioritizedTask task : mTaskList) {
                System.out.println(task.summary());
            }
            System.out.println(this + " calling shutdown");
            mExec.shutdownNow();
        }
    }
}

class PrioritizedTaskConsumer implements Runnable {

    private PriorityBlockingQueue<Runnable> mTaskQueue;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> q) {
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

class PrioritizedTaskProducer implements Runnable {

    private static Random sRandom = new Random();
    private Queue<Runnable> mTaskQueue;
    private ExecutorService mExec;

    public PrioritizedTaskProducer(Queue<Runnable> q, ExecutorService e) {
        mTaskQueue = q;
        mExec = e;
    }

    @Override
    public void run() {

        // fill the queue fast with random priorities
        System.out.println("0");
        for (int i = 0; i < 20; i++) {
            mTaskQueue.add(new PrioritizedTask(sRandom.nextInt(10)));
            Thread.yield();
        }
        System.out.println("1 size: " + mTaskQueue.size());
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mTaskQueue.add(new PrioritizedTask(10));
        }
        System.out.println("2 size: " + mTaskQueue.size());
        for (int i = 0; i < 10; i++) {
            mTaskQueue.add(new PrioritizedTask(i));
        }
        System.out.println("3 size: " + mTaskQueue.size());
        mTaskQueue.add(new PrioritizedTask.EndSentinel(-1, mExec));

    }
}

public class PriorityTaskDemo {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        PriorityBlockingQueue<Runnable> queue = new PriorityBlockingQueue<>();
        exec.execute(new PrioritizedTaskProducer(queue, exec));
        exec.execute(new PrioritizedTaskConsumer(queue));
    }
}
