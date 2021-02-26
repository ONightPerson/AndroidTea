package com.liubz.androidtea.cherish.designpattern.decorator;

/**
 * 通过Logger展示装饰者模式
 * author: created by liubaozhu on 2021/2/27
 * email: liubaozhu@baidu.com
 */
public class LoggerClient {

    public static void main(String[] args) {

        ILogger logger = new EncryptLogger(new FileLogger());
        logger.log("Hello");
    }
}
