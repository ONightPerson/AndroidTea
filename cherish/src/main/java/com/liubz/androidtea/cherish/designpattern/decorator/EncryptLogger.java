package com.liubz.androidtea.cherish.designpattern.decorator;

/**
 * author: created by liubaozhu on 2021/2/27
 * email: liubaozhu@baidu.com
 */
public class EncryptLogger extends LoggerDecorator {

    public EncryptLogger(ILogger logger) {
        super(logger);
    }

    @Override
    public void log(CharSequence c) {
        System.out.println("对数据[" + c + "]加密");
        super.log(c);
    }
}
