package com.liubz.androidtea.cherish.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: created by liubaozhu on 2020/7/5
 * email: liubaozhu@baidu.com
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLBlob {
    String name() default "";
    Constraints constraints() default @Constraints;
}
