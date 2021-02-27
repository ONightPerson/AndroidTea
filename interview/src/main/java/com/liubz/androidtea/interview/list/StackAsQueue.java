package com.liubz.androidtea.interview.list;

import java.util.LinkedList;

/**
 * author: created by liubaozhu on 2021/2/27
 * email: liubaozhu@baidu.com
 */
public class StackAsQueue<T> {
    private LinkedList<T> stack1;
    private LinkedList<T> stack2;

    public StackAsQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void enqueue(T a) {
        stack1.add(a);
    }

    public T dequeue() throws Exception {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                T a = stack1.pop();
                stack2.push(a);
            }
        }
        if (stack2.isEmpty()) {
            throw new Exception("queue is empty");
        }
        T result = stack2.pop();

        return result;
    }

    public boolean isEmpty() {
        return stack1.size() + stack2.size() <= 0;
    }

    public static void main(String[] args) {

        StackAsQueue<Integer> queue = new StackAsQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);


        while (!queue.isEmpty()) {
            try {
                System.out.println("dequeue item: " + queue.dequeue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
