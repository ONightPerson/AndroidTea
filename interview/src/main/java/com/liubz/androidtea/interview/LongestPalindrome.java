package com.liubz.androidtea.interview;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * author: created by liubaozhu on 2020-02-22
 * email: liubaozhu@baidu.com
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }


    private static String longestPalindrome(String s) {

        String result = method2(s);
        return result;
    }

    private static String method2(String s) {
        if (s == null || s == "") {
            return "";
        }
        int n = s.length();
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int single = expandBothEndian(s, i);
            int both = expandBothEndian(s, i, i + 1);
            int len = Math.max(single, both);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandBothEndian(String s, int center) {
        int i = center - 1;
        int j = center + 1;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    private static int expandBothEndian(String s, int centerLeft, int centerRight) {
        int i = centerLeft;
        int j = centerRight;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }


    private static String method1(String s) {
        if (s == null || s == "") {
            return "";
        }

        int n = s.length();

        Deque<Character> resultQue = null;
        int resultLen = 0;
        for (int i = 0; i < n; i++) {
            Deque<Character> queue = new LinkedList();
            Character cur = s.charAt(i);
            queue.offer(cur);
            int j = i - 1;
            int k = i + 1;
            addBothEndian(s, j, k, n, queue);
            System.out.println("i " + i + ", queue: " + queueToString(queue));
            int size = queue.size();
            if (resultLen < size) {
                resultQue = queue;
                resultLen = size;

            }
        }
        for (int i = 0; i < n - 1; i++) {
            char left = s.charAt(i);
            char right = s.charAt(i+1);
            if (left != right) {
                continue;
            }
            Deque<Character> queue = new LinkedList();
            queue.offer(left);
            queue.offer(right);
            int j = i - 1;
            int k = i + 2;
            addBothEndian(s, j, k, n, queue);
            System.out.println("i " + i + ", queue: " + queueToString(queue));
            int size = queue.size();
            if (resultLen < size) {
                resultQue = queue;
                resultLen = size;

            }
        }
        return queueToString(resultQue);
    }

    private static void addBothEndian(String s, int j, int k, int length, Deque<Character> queue) {
        while (j >= 0 && k < length) {
            char charJ = s.charAt(j);
            if (charJ != s.charAt(k)) {
                break;
            }
            queue.offerFirst(charJ);
            queue.offerLast(charJ);
            j--;
            k++;
        }
    }

    private static String queueToString(Queue<Character> queue) {
        if (queue != null) {
            Iterator<Character> iter = queue.iterator();
            StringBuilder builder = new StringBuilder();
            while (iter.hasNext()) {
                builder.append(iter.next());
            }
            return builder.toString();
        }
        return null;
    }
}
