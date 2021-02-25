package com.liubz.androidtea.cherish.classloader.load;

/**
 * Created by liubaozhu on 2021/2/22
 */
public class LoadMannerDemo {

    private static int sCount;

    static {
        sCount = 2;
        System.out.println("sCount: " + sCount);
        System.out.println("ConstTest init");
    }

    public LoadMannerDemo() {
        System.out.println("init");
    }

    public static void main(String[] args) {
        try {
            // 通过Class forName 加载，会进行类初始化
//            Class<?> clazz = Class.forName("com.liubz.androidtea.cherish.classloader.load.LoadMannerDemo");
            // 通过loadClass方法
            Class<?> clazz = ClassLoader.getSystemClassLoader().loadClass(
                    "com.liubz.androidtea.cherish.classloader.load.LoadMannerDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

