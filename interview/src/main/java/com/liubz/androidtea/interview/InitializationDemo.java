package com.liubz.androidtea.interview;

/**
 * author: created by liubaozhu on 2021/5/3
 * email: liubaozhu@baidu.com
 */

class Grandpa {
    static {
        System.out.println("爷爷在静态代码块");
    }

    public Grandpa() {
        // TODO
    }

//    public Grandpa(String name) {
//        System.out.println("我是爷爷~ name: " + name);
//    }
}

class Father extends Grandpa {
    static {
        System.out.println("爸爸在静态代码块");
    }

    public static int factor = 25;

    public Father() {
        System.out.println("我是爸爸~");
    }

//    public Father(String name) {
//        System.out.println("我是爸爸~ name: " + name);
//    }
}

class Son extends Father {
    static {
        System.out.println("儿子在静态代码块");
    }

    public Son() {
        System.out.println("我是儿子~");
    }

    public Son(String name) {
        System.out.println("我是儿子~ name: " + name);
    }
}

public class InitializationDemo {
    public static void main(String[] args) {
//        System.out.println("爸爸的岁数:" + Son.factor);    //入口
        Son son = new Son("lll");
    }
}
