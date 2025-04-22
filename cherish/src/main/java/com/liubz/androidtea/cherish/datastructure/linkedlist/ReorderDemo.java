package com.liubz.androidtea.cherish.datastructure.linkedlist;

import com.liubz.androidtea.cherish.datastructure.bean.Node;
import com.liubz.androidtea.cherish.utils.LinkedListUtils;

public class ReorderDemo {

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        reorderList(head);
        LinkedListUtils.print(head);
    }


    public static void reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        // 求中间节点的前驱节点
        Node centerPre = findCenter(head);
        Node secondHalfHead = centerPre.next;
        centerPre.next = null;
        Node reversedHead = LinkedListUtils.reverse(secondHalfHead);
        System.out.println("第一个链表");
        LinkedListUtils.print(head);
        System.out.println("第二个链表");
        LinkedListUtils.print(reversedHead);
        mergeTwoLinkedList(head, reversedHead);
    }

    public static Node findCenter(Node head) {
        Node s = head; // 慢指针
        Node q = head; // 快指针
        while (q.next != null && q.next.next != null) {
            q = q.next.next;
            s = s.next;
        }
        return s;
    }

    public static void mergeTwoLinkedList(Node l1, Node l2) {
        Node cur1 = l1;
        Node cur2 = l2;
        while (cur1 != null && cur2 != null) {
            Node next1 = cur1.next;
            Node next2 = cur2.next;
            cur1.next = cur2;
            cur2.next = next1;

            cur1 = next1;
            cur2 = next2;
        }

    }
}
