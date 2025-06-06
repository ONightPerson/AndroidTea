package com.liubz.androidtea.cherish.datastructure.queue;

import java.util.LinkedList;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *
 * 实现 MyStack 类：
 *
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *
 * 注意：
 *
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 *
 * 思路：
 */
public class QueuedStack<T> {
    private LinkedList<T> queue1 = new LinkedList<T>();
    private LinkedList<T> queue2 = new LinkedList<T>();

    public void push(T item) {
        queue2.offer(item);
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        LinkedList<T> temp = queue2;
        queue1 = queue2;
        queue2 = temp;
    }

    public T pop() {
        return queue1.poll();
    }

    public T top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
