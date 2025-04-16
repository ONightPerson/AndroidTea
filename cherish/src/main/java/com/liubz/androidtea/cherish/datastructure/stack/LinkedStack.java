package com.liubz.androidtea.cherish.datastructure.stack;

import com.liubz.androidtea.cherish.datastructure.bean.Node;

/**
 * 链式栈实现
 */
public class LinkedStack<T> {
    private Node<T> head;

    public LinkedStack() {
        this.head = null;
    }

    public void push(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    public T pop() {
        if (head == null) {
            return null;
        }
        Node<T> node = head;
        head = head.next;
        return node.data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedStack: [");
        Node<T> node = head;
        while (node != null) {
            sb.append(node.data).append(",");
            node = node.next;
        }
        sb.delete(sb.length() - 1, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
