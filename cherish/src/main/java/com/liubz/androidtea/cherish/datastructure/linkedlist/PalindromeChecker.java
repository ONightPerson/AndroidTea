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
        boolean isPalindrome = LinkedListUtils.isPalindrome(head);
        System.out.println("当前单链表存储的数据是否为回文结构:" + isPalindrome);
    }

    static Node createLinkedList() {
        Node<Integer> head = new Node(1);
        Node<Integer> next1 = new Node(2);
        head.next = next1;

        Node<Integer> next6 = new Node(4);
        next1.next = next6;
        Node<Integer> next7 = new Node(5);
        next6.next = next7;
        Node<Integer> next3 = new Node(2);
        next7.next = next3;
        Node<Integer> next4 = new Node(1);
        next3.next = next4;
        return head;
    }
}
