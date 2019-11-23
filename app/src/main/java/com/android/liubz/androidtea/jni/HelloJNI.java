package com.android.liubz.androidtea.jni;

/**
 * Created by liubaozhu on 2019-11-20
 */
public class HelloJNI {
    static {
        System.loadLibrary("hello");
    }

    public native void sayHello();

    public static void main(String[] args) {
        new HelloJNI().sayHello();
    }
}
