package com.liubz.androidtea.autoparcel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: created by liubaozhu on 2020/7/7
 * email: liubaozhu@baidu.com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface AutoParcel {
    int version() default 0;
}
