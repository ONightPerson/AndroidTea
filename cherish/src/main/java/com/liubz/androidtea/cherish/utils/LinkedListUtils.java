package com.liubz.androidtea.cherish.utils;

import com.liubz.androidtea.cherish.datastructure.bean.Node;

public class LinkedListUtils {

    public static void printList(Node<?> head) {
        if (head == null) {
            return;
        }
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummy = new Node(-1);
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = next;
        }
        return dummy.next;
    }

    public static boolean hasCycle(Node<?> head) {
        Node slow = head;
        Node fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static Node<Integer> merge(Node<Integer> n1, Node<Integer> n2) {
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> cur = dummy;
        while (n1 != null && n2 != null) {
            if (n1.data < n2.data) {
                cur.next = n1;
                n1 = n1.next;
            } else {
                cur.next = n2;
                n2 = n2.next;
            }
            cur = cur.next;

        }
        cur.next = (n1 == null) ? n2 : n1;

        return dummy.next;
    }

    /**
     * 删除链表的倒数第n个节点
     * 使用快慢指针解决
     * 1. 快指针先走 n+1 步
     * 2. 快慢指针同时走，当快指针走到链表末尾时，慢指针指向的就是倒数第n个节点的前驱节点
     * 3. 将慢指针的next指向待删除节点的后驱节点，并移除该节点
     * @param head
     * @param n
     * @return
     */
    public static Node removeNthFromEnd(Node head, int n) {
        if (head == null) {
            return null;
        }
        Node dummy = new Node(-1);
        dummy.next = head; // 哑结点指向头结点
        Node slow = dummy;
        Node fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        Node removeNode = slow.next;
        slow.next = slow.next.next;
        removeNode.next = null;
        return dummy.next;
    }
}
