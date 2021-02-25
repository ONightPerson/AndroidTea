package com.liubz.androidtea.cherish.classloader.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created by liubaozhu on 2021/2/25
 */
class MyPrinter {
    public void println(String s) {
        System.out.println(getClass().getName() + ": " + s);
    }
}

public class MethodHandleDemo {

    public static void main(String[] args) throws Throwable {
        test(System.out);
        test(new MyPrinter());
    }

    public static void test(Object o) throws Throwable {
        MethodType methodType = MethodType.methodType(void.class, String.class);
        MethodHandle handle = MethodHandles.lookup().findVirtual(o.getClass(), "println",
                methodType).bindTo(o);
        handle.invokeExact("hello world");

    }
}
