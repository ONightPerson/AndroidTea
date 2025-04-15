package com.liubz.androidtea.cherish.utils;

import com.liubz.androidtea.cherish.datastructure.bean.Node;

public class LinkedListUtils {

    public static void print(Node<?> head) {
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

    /**
     * 获取该链表的中间节点
     * 若链表节点数为奇数，则返回中间节点
     * 若链表节点数为偶数，则返回中间两个节点的后一个节点
     * 1 2 2
     * @param head
     * @return
     */
    public static Node findMiddleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean isPalindrome(Node head) {
        Node center = findMiddleNode(head);
        Node reversedSecondHalf = reverse(center);

        Node p1 = reversedSecondHalf;
        Node p2 = head;
        while (p1 != null) {
            if (p1.data != p2.data) {
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    /**
     * 删除链表中等于给定值 value 的所有节点
     * @param head
     * @param value
     * @return
     */
    public static Node<Integer> delete(Node<Integer> head, int value) {
        Node<Integer> dummy = new Node<>(-1);
        dummy.next = head;
        Node<Integer> p = dummy;
        while (p.next != null) {
            if (p.next.data == value) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }

        }

        return dummy.next;
    }
}
