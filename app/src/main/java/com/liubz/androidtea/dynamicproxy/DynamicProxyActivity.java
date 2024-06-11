package com.liubz.androidtea.dynamicproxy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import sun.misc.ProxyGenerator;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 6/6/24 11:27 AM
 */
public class DynamicProxyActivity {

    public static void main(String[] args) {

    }

    public static void writeClassToDisk() {
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Programmer.class});
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("D:\\$Proxy0.class");
            fos.write(classFile);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


