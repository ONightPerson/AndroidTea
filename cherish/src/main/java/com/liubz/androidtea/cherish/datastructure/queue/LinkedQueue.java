package com.liubz.androidtea.cherish.datastructure.queue;

import com.liubz.androidtea.cherish.datastructure.bean.Node;

import java.util.NoSuchElementException;

/**
 * 链式队列 数量没有限制
 *
 * 空队列：head == null
 *
 *  1 -> 2 -> 3
 *
 */
public class LinkedQueue<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T item = head.data;
        head = head.next;
        if (head == null) { // NOTE: 如果队列为空，tail也要置为null
            tail = null;
        }
        size--;
        return item;
    }
}
