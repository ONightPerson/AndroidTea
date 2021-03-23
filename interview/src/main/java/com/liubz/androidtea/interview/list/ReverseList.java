package com.liubz.androidtea.interview.list;

/**
 * author: created by liubaozhu on 2021/3/5
 * email: liubaozhu@baidu.com
 */
public class ReverseList {

    static class ListNode {

        public ListNode(int value) {
            this.value = value;
        }
        int value;
        ListNode next;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;

        }
        return pre;
    }

    public static ListNode reverseListRecursively(ListNode head) {
        if (head.next == null) return head;
        ListNode last = reverseListRecursively(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    private static ListNode createList() {
        ListNode head = new ListNode(5);
        ListNode next = new ListNode(7);
        head.next = next;
        ListNode next2 = new ListNode(8);
        next.next = next2;
        ListNode next3 = new ListNode(9);
        next2.next = next3;

        return head;
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = createList();

        ListNode reverseHead = reverseListRecursively(head);

        printList(reverseHead);

    }
}
