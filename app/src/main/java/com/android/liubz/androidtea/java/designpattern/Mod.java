package com.android.liubz.androidtea.java.designpattern;

/**
 * Created by liubaozhu on 2019-10-24
 */
public class Mod extends Operation {

    @Override
    public double op() throws Exception {
        if (mNumberB == 0) {
            throw new Exception("取余数不能为0");
        }
        return mNumberA % mNumberB;
    }
}
