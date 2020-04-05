package com.android.liubz.androidtea.java.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

/**
 * author: created by liubaozhu on 2020-02-23
 * email: liubaozhu@baidu.com
 */
public class ZConvert {
    Map<String, String> map = new HashMap() {
        {
            put("s", "string");
        }
    };
    static Set<String> right = new HashSet(){
        {
        add("}");
        add("]");
        add(")");}
    };

    public static void main(String[] args) {
//        System.out.println(hasGroupsSizeX(new int[]{1,1,1,2,2,2,3,3,3}));
//        System.out.println(Arrays.toString(pmt("abababca", 8)));
        System.out.println(~(-Integer.MIN_VALUE) + 1);
        System.out.println(Integer.MAX_VALUE);
        int[][] s = new int[8][8];
        he:
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[0].length;j++) {
                System.out.println("val: " + s[i][j]);
                break he;
            }
        }
    }

    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }

    public static boolean hasGroupsSizeX(int[] deck) {
        int n;
        if (deck == null || (n = deck.length) < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(deck[i])) {
                map.put(deck[i], map.get(deck[i]) + 1);
            } else {
                map.put(deck[i], 1);
            }
        }
        Collection<Integer> c = map.values();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        entries.size();
        Integer[] counts = c.toArray(new Integer[c.size()]);
        int gcd = counts[0];
        if (gcd == 1) {
            return false;
        }
        for (int i = 1; i < counts.length; i++) {
            gcd = gcd(gcd, counts[i]);
            if (gcd == 1) {
                return false;
            }
        }
        return true;
    }

    private static int gcd(int m, int n) {
        int tmp;
        while (n != 0) {
            tmp = m % n;
            n = m;
            m = tmp;
        }
        return m;

    }




    private static void test(int s) {
        Map<Integer, Integer> map = new HashMap<>();
        Collection<Integer> c = map.values();


    }

    private static int testDeque() {
        Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(3);

        Integer number;
        while ((number = queue.poll()) != null) {
            System.out.println(number);
        }

        Math.pow(number, 3);
        return number;
    }

    public static int reverse(int x) {
        if (x == 0) {
            return 0;
        }
        boolean isPositive = x > 0 ? true : false;
        System.out.println("isPositive: " + isPositive);
        int absX = Math.abs(x);
        while (absX % 10 == 0) {
            absX /= 10;
        }

        Deque<Integer> numbers = getNumbers(absX);

        int max = (int) Math.pow(2, 31) - (isPositive ? 1 : 0);
        System.out.println("max: " + max);
        Deque<Integer> compared = getNumbers(max);
        if (numbers.size() > compared.size()) {
            return 0;
        } else if (numbers.size() == compared.size()) {
            while (!numbers.isEmpty()) {
                Integer newNum = numbers.pollLast();
                Integer otherNum = compared.pollFirst();
                System.out.println("newNum: " + newNum + ", otherNum: " + otherNum);
                if (newNum > otherNum) {
                    return 0;
                } else if (newNum == otherNum) {
                    continue;
                } else {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(numbers.toArray()));

        Integer result = 0;
        int jieshu = 0;
        while(!numbers.isEmpty()) {
            Integer number = numbers.pop();
            System.out.println("number: " + number);
            result += (int) (number * Math.pow(10, jieshu));
            jieshu++;
        }
        return isPositive ? result : -result;
    }

    private static Deque<Integer> getNumbers(int x) {
        Deque<Integer> numbers = new LinkedList<>();
        while (x != 0) {
            numbers.addFirst(x % 10);
            x /= 10;
        }
        return numbers;
    }

    private static String zConvert(String s, int numRows) {
        if (s == null || numRows <= 0) {
            return "";
        }

        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // 换列条件 index % (2 * numRows - 2) (>= numRows || == 0) && index / (2* numRows - 2) > 0
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c: s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row: rows) {
            ret.append(row);
        }
        return ret.toString();
    }

    static class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int ans = 0;

            int rowLen = grid.length;
            int colLen = grid[0].length;
            for (int i = 0; i < rowLen; i++) {
                for (int j = 0; j < colLen; j++) {
                    int curAns = 0;
                    Queue<Integer> rowQue= new LinkedList<>();
                    Queue<Integer> colQue = new LinkedList<>();
                    rowQue.offer(i);
                    colQue.offer(j);

                    while (!rowQue.isEmpty()) {
                        int curRow = rowQue.poll();
                        int curCol = colQue.poll();

                        if (curRow < 0 || curCol < 0 || curRow >= rowLen || curCol >= colLen || grid[curRow][curCol] != 1) {
                            continue;
                        }
                        curAns++;
                        int[] rowDir = {1, -1, 0, 0};
                        int[] colDir = {0, 0, -1, 1};
                        grid[curRow][curCol] = 0;
                        for (int k = 0; k < 4; k++) {
                            rowQue.offer(curRow + rowDir[k]);
                            colQue.offer(curCol + colDir[k]);
                        }
                    }
                    ans = Math.max(ans, curAns);
                }
            }
            return ans;
        }
    }

    private static int[] pmt(String pattern, int n) {
         int[] pmt = new int[n];
         pmt[0] = 0;
         int val = 0;
         for (int i = 1; i < n; i++) {
             while (val > 0 && pattern.charAt(i) != pattern.charAt(val)) {
                 val = pmt[val-1];
             }
             if (pattern.charAt(i) == pattern.charAt(val)) {
                 val++;
             }
             pmt[i] = val;
         }
         return pmt;
    }


}
