package com.liubz.androidtea.cherish.thread;

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

        private CopyOnWriteArrayList<Integer> dataHolder;
        private final Exchanger<CopyOnWriteArrayList<Integer>> exchanger;

        public Producer(Exchanger<CopyOnWriteArrayList<Integer>> exchanger) {
            dataHolder = new CopyOnWriteArrayList<>();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    Random random = new Random();
                    for (int i = 0; i < 10; i++) {
                        dataHolder.add(random.nextInt(5000));
                    }
                    System.out.println("生产者队列已满，等待交换");
                    dataHolder = exchanger.exchange(dataHolder);
                    System.out.println("producer receive consumer buffer: " + dataHolder.size());
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Consumer implements Runnable {

        private CopyOnWriteArrayList<Integer> dataHolder;
        private final Exchanger<CopyOnWriteArrayList<Integer>> exchanger;
        private volatile Integer value;

        public Consumer(Exchanger<CopyOnWriteArrayList<Integer>> exchanger) {
            dataHolder = new CopyOnWriteArrayList<>();
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("消费者已准备好，等待交换");
                    dataHolder = exchanger.exchange(dataHolder);
                    System.out.println("consumer receive producer buffer: " + dataHolder.size());
                    for (Integer data : dataHolder) {
                        value = data;
                        dataHolder.remove(data);
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Final value: " + value);
        }
    }
}
