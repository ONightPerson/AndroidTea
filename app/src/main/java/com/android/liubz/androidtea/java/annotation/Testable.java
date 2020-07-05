package com.android.liubz.androidtea.java.annotation;

/**
 * author: created by liubaozhu on 2020/7/4
 * email: liubaozhu@baidu.com
 */
public class Testable {

    public void execute() {
        System.out.println("Executing ...");
    }

    @Test
    void testExecute() {
        execute();
    }
}
