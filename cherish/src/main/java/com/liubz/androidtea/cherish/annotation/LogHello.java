package com.liubz.androidtea.cherish.annotation;

import com.androidtea.myannotation.log.Log;

/**
 * author: created by liubaozhu on 2020/7/5
 * email: liubaozhu@baidu.com
 */
@Log
public class LogHello {
    public static void main(String[] args) {
       printMsg();
    }

    public static void printMsg() {
        System.out.println("Hello");
    }
}
