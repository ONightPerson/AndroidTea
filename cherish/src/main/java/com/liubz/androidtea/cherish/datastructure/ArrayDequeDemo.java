package com.liubz.androidtea.cherish.datastructure;

import java.lang.reflect.Field;
import java.util.ArrayDeque;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 3/19/24 4:18 PM
 */
public class ArrayDequeDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);

        Field field = ArrayDeque.class.getDeclaredField("head");
        field.setAccessible(true);
        int head = field.getInt(stack);
        System.out.println("head: " + head);
    }
}
