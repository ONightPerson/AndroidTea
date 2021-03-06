package com.liubz.androidtea.cherish.algorithm;

import java.util.Arrays;

/**
 * author: created by liubaozhu on 2021/2/21
 * email: liubaozhu@baidu.com
 */
public class StringCompare {
    public static void main(String[] args) {
        int index = indexOfByBM("aaabbaa", "abb");
        System.out.println("index: " + index);
    }

    public static int indexOfByBF(String main, String pattern) {
        if (main == null || pattern == null) {
            return -1;
        }
        int n = main.length();
        int m = pattern.length();
        if (n < m) {
            return -1;
        }
        for (int i = 0; i <= n - m; i++) {
            boolean match = true;
            for (int j = 0; j < m; j++) {
                if (pattern.charAt(j) != main.charAt(i + j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }

    public static int indexOfByBM(String main, String pattern) {
        if (main == null || pattern == null) {
            return -1;
        }
        char[] pArr = pattern.toCharArray();
        int m = pArr.length;
        char[] mArr = main.toCharArray();
        int n = mArr.length;
        // 创建一个简单的模式串散列表
        int[] table = new int[256];
        createPattenTable(pArr, m, table);

        int i = 0; // 主串与模式串对齐的第一个字符位置
        while (i <= n - m) {
            int j;
            for (j = m - 1; j >= 0; j--) {
                if (pArr[j] != mArr[i + j]) {
                    break;
                }
            }
            if (j < 0) {
                return i;
            }
            i += (j - table[mArr[i + j]]);
        }
        return -1;
    }

    private static void createPattenTable(char[] pattern, int m, int[] table) {
        // 初始化模式串字符与下表映射表
        Arrays.fill(table, -1);
        for (int i = 0; i < m; i++) {
            int index = pattern[i];
            table[index] = i;
        }
    }

}
