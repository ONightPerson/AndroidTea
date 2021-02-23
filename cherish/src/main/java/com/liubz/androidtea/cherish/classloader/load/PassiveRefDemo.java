package com.liubz.androidtea.cherish.classloader.load;

/**
 * Created by liubaozhu on 2021/2/22
 */
class Parent {
    static {
        System.out.println("Parent init");
    }

    public static int count = 1;
}

class Son extends Parent {
    static {
        System.out.println("Son init");
    }
}

// 测试
public class PassiveRefDemo {
    public static void main(String[] args) {
//        System.out.println(Son.count);
        Son[] sons = new Son[10];

    }
}
