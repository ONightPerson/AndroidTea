package com.liubz.androidtea.cherish.datastructure.linkedlist;

import com.liubz.androidtea.cherish.datastructure.bean.Node;
import com.liubz.androidtea.cherish.utils.LinkedListUtils;

/**
 * 删除链表的倒数第N个节点
 *
 * 举例：
 * # -> 1 2 3 4 5 6 7 8 null
 * s            f
 *
 * 共8个节点，删除倒数第8个节点（即删除 1）
 * 快指针先走 9步
 *
 *
 *
 */
public class DelNthLastNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);

        LinkedListUtils.removeNthFromEnd(head, 2);
        LinkedListUtils.printList(head);

    }
}
