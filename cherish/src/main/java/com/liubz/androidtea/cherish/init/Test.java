package com.liubz.androidtea.cherish.init;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: created by liubaozhu on 2020/6/7
 * email: liubaozhu@baidu.com
 */
public class Test {

    public static void main(String[] args) {
        long t = 90000L;
        long s = 800L;
        System.out.println((float) t / s);

        List<String> list1 = new ArrayList<>();
        list1.add("1");

        List<String> list2 = list1;
        list2.add("2");
        System.out.println("list1: " + Arrays.toString(list1.toArray()));

    }
}
