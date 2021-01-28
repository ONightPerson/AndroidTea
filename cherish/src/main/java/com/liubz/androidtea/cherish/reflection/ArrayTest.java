package com.liubz.androidtea.cherish.reflection;

import java.lang.reflect.Array;

/**
 * Created by liubaozhu on 2021/1/17
 */
public class ArrayTest {

    public static void main(String[] args) {
        Object array = Array.newInstance(String.class, 10);
        Array.set(array, 0, "1");
        Array.set(array, 1, "2");
        System.out.println(Array.get(array, 0));
        System.out.println(Array.get(array, 1));

        Object threeDimens = Array.newInstance(String.class, 10, 3, 3);
        Object twoDimens = Array.get(threeDimens, 0);
        Array.set(twoDimens, 0, new String[] {
                "Hello",
                "Hi",
                "Hey"
        });
        Object oneDimen = Array.get(twoDimens, 1);
        Array.set(oneDimen, 2, "MyWorld");
        String[][][] cast = (String[][][]) threeDimens;
        System.out.println(cast[0][1][2]);
        System.out.println(cast[0][0][1]);
        System.out.println(cast[0][0][2]);
    }
}
