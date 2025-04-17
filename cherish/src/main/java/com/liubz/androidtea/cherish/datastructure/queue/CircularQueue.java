package com.liubz.androidtea.cherish.datastructure.queue;

/**
 * 循环队列
 * @param <T>
 */
public class CircularQueue<T> {
    private Object[] items;
    private int n = 0;
    int head = 0;
    int tail = 0;
    public CircularQueue(int capacity) {
        this.items = new Object[capacity];
        int n = capacity;
    }


    /**
     1  2   3
     */
    public boolean enqueue(T data) {
        // 队列已满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = data;
        tail = (tail + 1) % n;
        return true;
    }

    public T dequeue() {
        // 队列为空
        if (tail == head) {
            return null;
        }
        T item = (T) items[head];
        head = (head + 1) % n; // NOTE head与tail一样，都是累加
        return item;
    }
}