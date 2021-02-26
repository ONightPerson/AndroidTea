package com.liubz.androidtea.cherish.designpattern.decorator;

/**
 * author: created by liubaozhu on 2021/2/26
 * email: liubaozhu@baidu.com
 */
public class FileLogger implements ILogger {
    @Override
    public void log(CharSequence c) {
        System.out.println("log to file: " + c);
    }
}
