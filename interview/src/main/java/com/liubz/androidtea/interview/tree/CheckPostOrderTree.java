package com.liubz.androidtea.interview.tree;

/**
 * 给定一个整数数组，判断是否为二叉搜索树的后序遍历的结果
 * author: created by liubaozhu on 2021/2/25
 * email: liubaozhu@baidu.com
 */
public class CheckPostOrderTree {

    public static boolean verifySequenceOfBST(int[] sequence) {
        int len;
        if (sequence == null || (len = sequence.length) <= 0) {
            return false;
        }
        return handleVerifySequence(sequence, 0, len - 1);
    }

    private static boolean handleVerifySequence(int[] sequence, int start, int end) {
        if (start > end) {
            return true;
        }
        int root = sequence[end];
        int i = start;
        while (sequence[i] < root) {
            i++;
        }
        System.out.println("i: " + i);
        int j = i;
        for (; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        boolean left = handleVerifySequence(sequence, start, i - 1);
        if (!left) {
            return false;
        }
        boolean right = handleVerifySequence(sequence, i, end - 1);
        if (!right) {
            return false;
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[] sequence = {12, 14, 13, 16, 17, 15};
        boolean result = verifySequenceOfBST(sequence);
        System.out.println("result: " + result);
    }

}
