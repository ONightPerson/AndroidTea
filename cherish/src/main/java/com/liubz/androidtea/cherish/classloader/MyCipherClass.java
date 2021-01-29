package com.liubz.androidtea.cherish.classloader;

import static com.liubz.androidtea.cherish.classloader.CypherUtils.cypher;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by liubaozhu on 2020/11/12
 */
public class MyCipherClass {

    public MyCipherClass() {
        System.out.println("CipherClass object was created");
    }

    public static void main(String[] args) {
        System.out.println("cypher current class file");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            String srcFilePath = CLConstants.OUTPUT_CLASS_DIR + "com/liubz"
                    + "/androidtea/cherish/classloader/MyCipherClass.class";
            fis = new FileInputStream(srcFilePath);
            fos = new FileOutputStream(srcFilePath);
            cypher(fis, fos);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

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
