package com.liubz.androidtea.cherish.designpattern.decorator;

/**
 * author: created by liubaozhu on 2021/2/27
 * email: liubaozhu@baidu.com
 */
public abstract class LoggerDecorator implements ILogger {

    private ILogger mLogger;

    public LoggerDecorator(ILogger logger) {
        this.mLogger = logger;
    }

    @Override
    public void log(CharSequence c) {
        mLogger.log(c);
    }
}
