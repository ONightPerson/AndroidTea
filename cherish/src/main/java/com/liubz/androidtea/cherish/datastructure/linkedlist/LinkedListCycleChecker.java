package com.liubz.androidtea.cherish.datastructure.linkedlist;

import com.liubz.androidtea.cherish.datastructure.bean.Node;
import com.liubz.androidtea.cherish.utils.LinkedListUtils;

/**
 * 检查链表是否有环
 * <p>
 * <p>
 * 1 2 3
 */
public class LinkedListCycleChecker {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n1 = new Node(2);
        head.next = n1;
        n1.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = n1;

        System.out.println("链表是否有环：" + LinkedListUtils.hasCycle(head));
    }
}
