package com.android.liubz.androidtea.java.concurrency;

/**
 * author: created by liubaozhu on 2020/5/24
 * java -cp bin -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly,*VolatileTest.a com.android.liubz.androidtea.java.concurrency.VolatileTest > Volatile.asm
 * email: liubaozhu@baidu.com
 */

public class VolatileTest {

    public static void main(String[] args) {
        VolatileTest.a();
    }

    public static void a() {
        int i = 0x12345678;
        int j = i + 1;
        System.out.println(j);
    }
}
