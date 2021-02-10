package com.liubz.androidtea.cherish.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liubaozhu on 2021/2/10
 */
public class ExchangerTest {

    public static void main(String[] args) {
        Exchanger<CopyOnWriteArrayList<Integer>> exchanger = new Exchanger<>();
        ExecutorService executor = Executors.newCachedThreadPool();
        executor.execute(new Producer(exchanger));
        executor.execute(new Consumer(exchanger));
        executor.shutdown();
    }

    static class Producer implements Runnable {

        private CopyOnWriteArrayList<Integer> dataBuffer;
        private final Exchanger<CopyOnWriteArrayList<Integer>> exchanger;

        public Producer(Exchanger<CopyOnWriteArrayList<Integer>> exchanger) {
            dataBuffer = new CopyOnWriteArrayList<>();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                while (dataBuffer != null && !Thread.interrupted()) {
                    Random random = new Random();
                    for (int i = 0; i < 10; i++) {
                        dataBuffer.add(random.nextInt(5000));
                    }
                    System.out.println("生产者队列已满，等待交换");
                    dataBuffer = exchanger.exchange(dataBuffer);
                    System.out.println("producer receive consumer buffer: " + dataBuffer.size());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private CopyOnWriteArrayList<Integer> dataBuffer;
        private final Exchanger<CopyOnWriteArrayList<Integer>> exchanger;

        public Consumer(Exchanger<CopyOnWriteArrayList<Integer>> exchanger) {
            dataBuffer = new CopyOnWriteArrayList<>();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                while (dataBuffer != null && !Thread.interrupted()) {
                    for ()
                    System.out.println("生产者队列已满，等待交换");
                    dataBuffer = exchanger.exchange(dataBuffer);
                    System.out.println("producer receive consumer buffer: " + dataBuffer.size());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
