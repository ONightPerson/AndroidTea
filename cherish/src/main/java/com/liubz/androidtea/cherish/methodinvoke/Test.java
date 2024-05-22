package com.liubz.androidtea.cherish.methodinvoke;

import com.liubz.androidtea.cherish.methodinvoke.overxxx.Animal;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 12/12/23 4:44 PM
 */
public class Test {

    public static void main(String[] args) {
        Base base = new Base();
        base.sFunc("sss");
        base.sFunc(new Object());
        base.func("sss");
        base.func(new Object());

        Base child1 = new Child();
        child1.sFunc("sss");
        child1.sFunc(new Object());
        child1.func("sss");
        child1.func(new Object());

        Child child2 = new Child();
        child2.sFunc("sss");
        child2.sFunc(new Object());
        child2.func("sss");
        child2.func(new Object());

        Animal parent = new BritishShortHairCat();
        parent.eat();
    }
}
