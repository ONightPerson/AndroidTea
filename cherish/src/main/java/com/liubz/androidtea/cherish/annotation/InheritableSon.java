package com.liubz.androidtea.cherish.annotation;

/**
 * Created by liubaozhu on 2020-01-17
 */
public class InheritableSon extends InheritableFather {

    public InheritableSon() {
        System.out.println("InheritableSon: " + InheritableSon.class.isAnnotationPresent(MyAnnotation.class));
    }

    public static void main(String[] args) {
        InheritableSon is = new InheritableSon();
    }
}
