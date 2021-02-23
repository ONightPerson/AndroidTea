package com.liubz.androidtea.cherish.classloader.load;

/**
 * Created by liubaozhu on 2021/2/22
 */
class TestClass {
    static {
        System.out.println("ConstClass init");
    }

    public static final String HELLO_WORLD = "HelloWorld";

}

public class ConstLoadClass {
    public static void main(String[] args) {
        System.out.println(TestClass.HELLO_WORLD);
    }
}
