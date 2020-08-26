package com.liubz.androidtea.cherish.datastructure;

/**
 * Created by liubaozhu on 2020/8/10
 */
public class Node {

    public int data;
    public Node next;

    public Node (int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                "}";
    }
}
