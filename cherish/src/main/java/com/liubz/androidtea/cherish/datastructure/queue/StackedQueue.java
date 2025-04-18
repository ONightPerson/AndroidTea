package com.liubz.androidtea.cherish.datastructure.queue;

import java.util.LinkedList;

/**
 * 双栈实现队列
 * 实现思路：
 * 一个栈用于输入，一个栈用于输出，当输出栈为空时，将输入栈的数据全部弹出并压入输出栈，此时输出栈的出栈顺序与队列顺序保持一致
 */
public class StackedQueue<T> {
    private LinkedList<T> inStack;
    private LinkedList<T> outStack;

    public StackedQueue() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(T item) {
        inStack.push(item);
    }

    public T pop() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.pop();
    }

    public T peek() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        return outStack.isEmpty();
    }

    private void inToOut() {
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }
    }
}
