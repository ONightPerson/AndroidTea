package com.liubz.androidtea.cherish.designpattern;

/**
 * Created by liubaozhu on 2019-10-24
 */
public class Div extends Operation {

    @Override
    public double op() throws Exception {
        if (mNumberB ==0) {
            throw new Exception("除数不能为0");
        }
        return mNumberA / mNumberB;
    }
}
