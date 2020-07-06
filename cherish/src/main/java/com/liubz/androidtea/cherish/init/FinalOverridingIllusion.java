package com.liubz.androidtea.cherish.init;

/**
 * author: created by liubaozhu on 2020/6/9
 * email: liubaozhu@baidu.com
 */
class WithFinals {

    private final void f() {
        System.out.println("WithFinals f");
    }

    private void g() {
        System.getProperty("WithFinals g");
    }
}


class OverridePrivate extends WithFinals {

    private final void f() {
        System.out.println("OverridePrivate f");
    }

    private void g() {
        System.getProperty("OverridePrivate g");
    }
}

class OverridingPrivate2 extends OverridePrivate {
    public final void f() {
        System.out.println("OverridingPrivate2 f");
    }

    public void g() {
        System.getProperty("OverridingPrivate2 g");
    }
}

public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate2 op2 = new OverridingPrivate2();
        op2.f();
        op2.g();

        WithFinals wf = op2;
    }
}


