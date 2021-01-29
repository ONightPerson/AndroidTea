package com.liubz.androidtea.cherish.classloader;

import static com.liubz.androidtea.cherish.classloader.CypherUtils.cypher;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/**
 * Created by liubaozhu on 2021/1/28
 */
public class CipherClassLoader extends ClassLoader {

    private final String mClassDir;

    public CipherClassLoader(String classDir) {
        mClassDir = classDir;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        System.out.println("ClassLoader: " + this + ", loadClass name: " + name);
        return super.loadClass(name, resolve);
    }

    @Override
    protected Class<?> findClass(String name) {
        // 定位加密后的 class 字节码文件
        System.out.println("name: " + name);
        String classFilePath = mClassDir + name.substring(name.lastIndexOf(".") + 1) +
                ".class";
        System.out.println("classFilePath: " + classFilePath);
        try {
            FileInputStream fis = new FileInputStream(classFilePath);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            // 将加密的 class 字节码进行解密
            cypher(fis, bos);
            bos.flush();
            byte[] bytes = bos.toByteArray();
            // 将正常的 class 字节流转成 Class 对象
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 测试
    public static void main(String[] args) throws Exception {
        Class<?> clazz = new CipherClassLoader("/Users/liubaozhu/CommonRepo/AndroidTea/bin/com"
                + "/liubz/androidtea/cherish/classloader/").loadClass(
                "com.liubz.androidtea.cherish.classloader.MyCipherClass");
        clazz.newInstance();
    }
}
