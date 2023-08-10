package com.liubz.androidtea.cherish.algorithm;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: created by liubaozhu on 2021/2/21
 * email: liubaozhu@baidu.com
 */
public class StringCompare {
    public static void main(String[] args) {
//        int index = indexOfByBM("aaabbaa", "abb");
//        System.out.println("index: " + index);
//        matchStr();
        getHttpContent();
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

    private static void matchStr() {
        Pattern pattern = Pattern.compile("^https?://([^\\/]+)-sl-(.*\\.html)");
        String url = "https://waimai-eci-221121-145807-204-sl-sqt.waimai.test.sankuai.com/c/home/index.html#/r/home";
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String swimLane = matcher.group(1);
            System.out.println(swimLane);
            String pageUrl = matcher.group(2);
            System.out.println(pageUrl);
        } else {
            System.out.println("未匹配到结果");
        }
    }

    private static void getHttpContent() {
        String url = "https://waimai-eci-221121-145807-204-sl-sqt.waimai.test.sankuai.com/c/home/index.html#/r/home";
        Pattern pattern = Pattern.compile("(https?://)(.+)");
        Matcher matcher = pattern.matcher(url);
        if (matcher.find()) {
            String protocol = matcher.group(1);
            String rest = matcher.group(2);
            System.out.println("协议部分：" + protocol);
            System.out.println("剩余部分：" + rest);
        }
    }


}
