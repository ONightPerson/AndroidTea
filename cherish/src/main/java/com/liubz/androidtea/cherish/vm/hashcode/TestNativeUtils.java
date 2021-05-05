package com.liubz.androidtea.cherish.vm.hashcode;

/**
 * author: created by liubaozhu on 2021/5/10
 * email: liubaozhu@baidu.com
 */
public class TestNativeUtils {

    public static void main(String[] args) {
        Object o = new Object();
        long addr = NativeUtils.getObjAddress(o);
        System.out.println(String.format("addr: %x, hashcode: %x", addr, o.hashCode()));
    }
}
