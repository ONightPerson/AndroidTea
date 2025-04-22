package com.liubz.androidtea.cherish.datastructure.bean;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data == null ? "null" : data.toString();
    }
}
