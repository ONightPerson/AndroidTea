package com.liubz.androidtea.cherish.methodinvoke;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 12/12/23 4:39 PM
 */
public class Child extends Base {

    public static void sFunc(String s) {
        System.out.println(getInfo(s));
    }

    public static void sFunc(Object s) {
        System.out.println(getInfo(s));
    }

    @Override
    public void func(String s) {
        System.out.println(getInfo(s));
    }

    @Override
    public void func(Object s) {
        System.out.println(getInfo(s));
    }

    public static String getInfo(Object s) {
        StringBuilder builder = new StringBuilder();
        builder.append(Child.class.getSimpleName())
          .append("--")
          .append(Thread.currentThread().getStackTrace()[1].getMethodName())
          .append("--")
          .append(s);
        return builder.toString();
    }
}
