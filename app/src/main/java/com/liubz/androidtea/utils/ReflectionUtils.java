package com.liubz.androidtea.utils;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;

public class ReflectionUtils {

    @MyMethodAnnotation
    public void myMethod(@MyParamAnnotation String param1, int param2) {
        // 方法逻辑
    }

    public static void test() throws NoSuchMethodException {
        Method method = ReflectionUtils.class.getMethod("myMethod", String.class, int.class);

        // 获取方法注解
        Annotation[] methodAnnotations = method.getAnnotations();
        System.out.println("Method Annotations:");
        for (Annotation annotation : methodAnnotations) {
            System.out.println(annotation.annotationType().getSimpleName());
        }

        // 获取参数类型（包括泛型）
        Type[] parameterTypes = method.getGenericParameterTypes();
        System.out.println("Parameter Types:");
        for (Type type : parameterTypes) {
            System.out.println(type.getTypeName());
        }

        // 获取参数注解
        Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();
        System.out.println("Parameter Annotations:" + Arrays.toString(parameterAnnotationsArray));
        for (Annotation[] annotations : parameterAnnotationsArray) {
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType().getSimpleName());
            }
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface MyMethodAnnotation {}

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.PARAMETER)
    @interface MyParamAnnotation {}
}