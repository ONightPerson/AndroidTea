package com.liubz.androidtea.cherish.init;

/**
 * author: created by liubaozhu on 2020/6/7
 * email: liubaozhu@baidu.com
 */
public class EnumTest {

    private enum Animal {
        CAT, DOG, PIG, FOX
    }

    public static void main(String[] args) {
        for (Animal animal : Animal.values()) {
            System.out.println(animal + ", ordinal: " + animal.ordinal());
        }
    }
}
