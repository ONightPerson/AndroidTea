package com.liubz.androidtea.cherish.designpattern;

/**
 * Created by liubaozhu on 2019-10-22
 */
public abstract class Operation {

    protected double mNumberA = 0;
    protected double mNumberB = 0;

    public void setNumber(double a, double b) {
        mNumberA = a;
        mNumberB = b;
    }
    public abstract double op() throws Exception;
}
