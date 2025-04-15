package com.liubz.androidtea.cherish.datastructure.linkedlist;

import com.liubz.androidtea.cherish.datastructure.bean.Node;
import com.liubz.androidtea.cherish.utils.LinkedListUtils;

/**
 * 回文字符串检测
 * 给定单链表，判断链表中的节点数据是否是回文结构
 * 检测步骤：
 * 1. 找到链表的中点，通过快慢指针实现
 * 2. 反转中点之后的链表
 * 3. 比较中点之前的链表和反转之后的链表是否相同
 *
 * 1 2 3 2 1
 *
 * 1 2 3 3 2 1
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        Node head = createLinkedList();
//        boolean isPalindrome = isPalindrome(head);
//        System.out.println("当前单链表存储的数据是否为回文结构:" + isPalindrome);
        Node reversedHead = reverseLinkedList(head);
        System.out.println("反转链表");
        LinkedListUtils.printList(reversedHead);
    }

    static Node createLinkedList() {
        Node<Integer> head = new Node(1);
        Node<Integer> next1 = new Node(2);
        head.next = next1;
        Node<Integer> next2 = new Node(4);
        next1.next = next2;
        Node<Integer> next6 = new Node(3);
        next2.next = next6;
        Node<Integer> next3 = new Node(2);
        next6.next = next3;
        Node<Integer> next4 = new Node(1);
        next3.next = next4;
        return head;
    }

    static boolean isPalindrome(Node head) {
        Node center = findMiddle(head);
        Node reverseHead = reverseLinkedList(center.next);

        Node p1 = reverseHead;
        Node p2 = head;
        boolean isPalindrome = true;
        while (p1 != null) {
            if (p1.data != p2.data) {
                isPalindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return isPalindrome;
    }

    /**
     *  找到当前链表的中间节点
     *  1. 若节点数为奇数，则返回中间节点
     *  2. 若
     * @param head 单链表头结点
     * @return
     */
    static Node findMiddle(Node head) {
        // 若为空链表或链表只有单个节点，则直接返回头结点
        if (head == null || head.next == null) {
            return head;
        }
        Node s = head; // 慢指针，每次遍历1个节点
        Node q = head; // 快指针，每次遍历2个节点
        while (q != null && q.next != null) {
            s = s.next;
            q = q.next.next;
        }
        return s;
    }

    static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummyHead = new Node(-1);
        Node p = head;
        Node n;
        while (p != null) {
            n = p.next;
            p.next = dummyHead.next;
            dummyHead.next = p;
            p = n;
        }
        return dummyHead.next;

    }
}
