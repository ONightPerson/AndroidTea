package com.liubz.androidtea.cherish.algorithm.recursion;

import com.liubz.androidtea.cherish.datastructure.bean.Node;
import com.liubz.androidtea.cherish.utils.LinkedListUtils;

import java.util.HashMap;

public class RecursionDemo {

    public static void main(String[] args) {

        Node<Integer> l1 = new Node<>(3);
        l1.next = new Node<>(8);
        l1.next.next = new Node<>(2);
        Node<Integer> l2 = new Node<>(8);
        l2.next = new Node<>(2);
        l2.next.next = new Node<>(9);
        //  928 + 283 = 1211

        // 243 + 24 = 267
//        Node<Integer> result = addTwoNumbersRecursively(l1, l2);
//        LinkedListUtils.print(result);
        Node<Integer> result = addTwoNumbersIteratively(l1, l2);
        LinkedListUtils.print(result);
    }

    /**
     * n 个台阶，一次可以走 1 级或者 2 级台阶，请问走 n 级台阶有多少种走法？
     * 递推公式 f(n) = f(n-1) + f(n-2)
     * 终止条件 f(1) = 1, f(2) = 2
     *
     * @param n
     * @return
     */
    public static int getStepsRecursively(int n) {
        HashMap<Integer, Integer> resolvedMap = new HashMap<>();
        if (n <= 2) {
            return n;
        }
        if (resolvedMap.containsKey(n)) {
            return resolvedMap.get(n);
        }
        int result = getStepsRecursively(n - 1) + getStepsRecursively(n - 2);
        resolvedMap.put(n, result);
        return result;
    }

    public static int getStepsIteratively(int n) {
        if (n <= 2) {
            return n;
        }
        int result = 0;
        int pre = 2;
        int prePre = 1;
        for (int i = 3; i <= n; i++) {
            result = pre + prePre;
            prePre = pre;
            pre = result;
        }
        return result;
    }

    /**
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * [ 3 -> 4 - > 2]
     * [ 8 -> 2]
     *
     * 243 + 28 = 271
     *
     *  R(i) = R(i-1) + 进位
     *  递归方式
     */
    public static Node<Integer> addTwoNumbersRecursively(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(-1);
        int carry = 0;
        addTwoNumbersRecursively(dummy, l1, l2, carry);
        return dummy.next;
    }

    public static void addTwoNumbersRecursively(Node<Integer> cur, Node<Integer> l1, Node<Integer> l2, int carry) {
        if (l1 != null || l2 != null || carry > 0) {
            int num1 = l1 == null ? 0 : l1.data;
            int num2 = l2 == null ? 0 : l2.data;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            Node<Integer> node = new Node<>(sum % 10);
            cur.next = node;
            addTwoNumbersRecursively(node, l1 == null ? null : l1.next, l2 == null ? null : l2.next, carry);
        }
    }

    public static Node<Integer> addTwoNumbersIteratively(Node<Integer> l1, Node<Integer> l2) {
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {
            int num1 = l1 == null ? 0 : l1.data;
            int num2 = l2 == null ? 0 : l2.data;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            cur.next = new Node<>(sum % 10);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next; // NOTE: 迭代
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }
}
