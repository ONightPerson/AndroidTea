package com.liubz.androidtea.interview;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * author: created by liubaozhu on 2021/3/14
 * email: liubaozhu@baidu.com
 */
public class LeastKNum {


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.getLeastNumbers(new int[] {1, 3, 8, 7, 6, 2}, 6);
    }

    static class Solution {

        public void getLeastNumbers(int[] arr, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
                public int compare(Integer num1, Integer num2) {
                    return num2 - num1;
                }
            });

            for (int i = 0; i < k; ++i) {
                queue.offer(arr[i]);
            }

            while (!queue.isEmpty()) {
                int num = queue.poll();
                System.out.println("num: " + num);
            }
        }
    }
}
