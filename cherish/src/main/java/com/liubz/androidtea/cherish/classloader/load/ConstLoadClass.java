package com.liubz.androidtea.cherish.classloader.load;

/**
 * Created by liubaozhu on 2021/2/22
 */

public class ConstLoadClass {
    public static void main(String[] args) {
        classLoader();
        getClassLoader();
    }


    static void classLoader() {
        String classpath, bootPath, extPath;

        try {
            classpath = System.getProperty("java.class.path");
            bootPath = System.getProperty("sun.boot.class.path");
            extPath = System.getProperty("java.ext.dirs");
            System.out.println("classpath: " + classpath + ", bootPath: " + bootPath + ", extPath: " + extPath);
        } catch (SecurityException e) {
        }
    }

    static void getClassLoader() {
        ClassLoader loader = ConstLoadClass.class.getClassLoader();
        while (loader != null) {
            System.out.println(loader);
            loader = loader.getParent();
        }
    }
}
