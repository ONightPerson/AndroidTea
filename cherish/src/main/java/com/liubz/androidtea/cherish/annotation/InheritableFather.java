package com.liubz.androidtea.cherish.annotation;

/**
 * Created by liubaozhu on 2020-01-17
 */

@MyAnnotation
public class InheritableFather {
    public InheritableFather() {
        System.out.println("InheritableFather: " + InheritableFather.class.isAnnotationPresent(MyAnnotation.class));
    }
}
