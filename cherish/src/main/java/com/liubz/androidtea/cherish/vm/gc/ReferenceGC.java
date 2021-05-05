package com.liubz.androidtea.cherish.vm.gc;

/**
 * author: created by liubaozhu on 2021/5/10
 * email: liubaozhu@baidu.com
 */
public class ReferenceGC {

    public static void main(String[] args) {
        _2MB_Data d1 = new _2MB_Data();
        _2MB_Data d2 = new _2MB_Data();
        d1.instance = d2;
        d2.instance = d1;
        d1 = null;
        d2 = null;
        System.gc();
    }
}

class _2MB_Data {
    public Object instance = null;
    private byte[] data = new byte[2 * 1024 * 1024];
}
