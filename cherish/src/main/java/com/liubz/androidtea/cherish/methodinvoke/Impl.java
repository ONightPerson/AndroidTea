package com.liubz.androidtea.cherish.methodinvoke;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 12/12/23 5:00 PM
 */
public class Impl extends Base {
    @Override
    public void func(String s) {
        super.sFunc("");
    }

    void test1() {
        func("sss");
        func1();
        func2();
    }

    public final void  func1() {

    }

    void test2() {
        super.func("sss");
    }

    private void func2() {

    }


}
