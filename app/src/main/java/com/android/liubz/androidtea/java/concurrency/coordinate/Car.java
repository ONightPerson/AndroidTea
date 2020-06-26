package com.android.liubz.androidtea.java.concurrency.coordinate;

/**
 * author: created by liubaozhu on 2020/6/26
 * email: liubaozhu@baidu.com
 */
public abstract class Car {

    public abstract void notifyWaxing() throws InterruptedException;
    public abstract void notifyPolishing() throws InterruptedException;
    public abstract void waitingForWaxing() throws InterruptedException;
    public abstract void waitingForPolishing() throws InterruptedException;

}
