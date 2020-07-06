package com.liubz.androidtea.cherish.innerclass;

/**
 * author: created by liubaozhu on 2020/5/16
 * email: liubaozhu@baidu.com
 */
public class InnerClassTest {

    public static void main(String[] args) {

        Wrapping wrapping = getWrapping(5);
        wrapping.f();

    }

    private static Wrapping getWrapping(int x) {

        return new Wrapping(x) {
            {System.out.println("Inside instance initializer");}
            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    static abstract class Wrapping {
        public Wrapping(int x) {
            System.out.println("Base constructor: " + x);
        }

        public abstract void f();
    }
}
