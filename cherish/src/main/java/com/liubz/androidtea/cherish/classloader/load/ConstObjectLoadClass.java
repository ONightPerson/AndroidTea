package com.liubz.androidtea.cherish.classloader.load;

/**
 * Created by liubaozhu on 2021/2/22
 */
class ConstObjectClass {

    static {
        System.out.println("ConstTest init");
    }

    public static final Object HELLO_WORLD = "HelloWorld";
}

public class ConstObjectLoadClass {
    public static void main(String[] args) {
//        System.out.println(ConstObjectClass.HELLO_WORLD);
        try {
//            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(
//                    "com.liubz.androidtea.cherish.classloader.load.LoadMannerDemo");
            Class<?> clazz = Class.forName("com.liubz.androidtea.cherish.classloader.load.LoadMannerDemo");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
