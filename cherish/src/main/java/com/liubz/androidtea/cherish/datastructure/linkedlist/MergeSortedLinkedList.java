package com.liubz.androidtea.cherish.datastructure.linkedlist;

import com.liubz.androidtea.cherish.datastructure.bean.Node;
import com.liubz.androidtea.cherish.utils.LinkedListUtils;

/**
 * 合并两个有序链表
 */
public class MergeSortedLinkedList {
    public static void main(String[] args) {
        Node<Integer> head1 = new Node(1);
        head1.next = new Node(3);
        head1.next.next = new Node(5);
        head1.next.next.next = new Node(12);

        Node<Integer> head2 = new Node(2);
        head2.next = new Node(4);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(8);
        System.out.println("开始合并");
        Node head = LinkedListUtils.merge(head1, head2);
        System.out.println("合并2个有序链表：");
        LinkedListUtils.print(head);
    }
}
