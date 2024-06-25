package com.liubz.androidtea.cherish.annotation.typevariable;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/15/24 10:56 AM
 */
public class TypeVariableTest {
    public static interface MyInterface<T extends Number> {
    }

    public static void main(String[] args) {
        TypeVariable<Class<MyInterface>>[] tvs = MyInterface.class.getTypeParameters();
        for (TypeVariable<Class<MyInterface>> tv : tvs) {
            Type[] bounds = tv.getBounds();
            System.out.println("bounds: " + Arrays.toString(bounds));
            System.out.println(": GenericDeclaration" + tv.getGenericDeclaration());
            System.out.println("name: " + tv.getName());
        }
    }
}
