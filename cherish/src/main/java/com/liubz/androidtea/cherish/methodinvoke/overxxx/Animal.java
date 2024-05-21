package com.liubz.androidtea.cherish.methodinvoke.overxxx;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 5/15/24 7:53 PM
 */
public class Animal {
    public void eat() {
        System.out.println(this.getClass().getSimpleName() + " eat");
    }

    public void sleep() {
        System.out.println(this.getClass().getSimpleName() + " sleep");
    }
}
