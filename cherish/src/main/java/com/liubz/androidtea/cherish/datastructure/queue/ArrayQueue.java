package com.liubz.androidtea.cherish.datastructure.queue;

/**
 * 顺序队列
 * @param <T>
 */
public class ArrayQueue<T> {
    private Object[] queue;
    private int capacity;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        queue = new Object[capacity];
        this.capacity = capacity;
        head = 0;
        tail = 0;
    }

    public boolean isFull() {
        return tail == capacity;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean enqueue(T item) {
        if (isFull()) {
            return false;
        }
        queue[tail] = item;
        tail++;
        return true;
    }

    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T item = (T) queue[head];
        head++;
        return item;
    }
}
