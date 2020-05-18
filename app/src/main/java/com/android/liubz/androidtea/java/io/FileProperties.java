package com.android.liubz.androidtea.java.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * author: created by liubaozhu on 2020/5/16
 * email: liubaozhu@baidu.com
 */
public class FileProperties {

    public static void main(String[] args) {
        fileData(new File("/Users/liubaozhu/local_repo/AndroidTea/app/src/main/java/com" +
                "/android/liubz/androidtea/java/io/filelist"));
    }

    private static void fileData(File f) {
        try {
            System.out.println("Absolute path: " + f.getAbsolutePath() +
                    "\n getCanonicalPath: " + f.getCanonicalPath() +
                    "\n Can read: " + f.canRead() +
                    "\n Can write: " + f.canWrite() +
                    "\n getName: " + f.getName() +
                    "\n getParent: " + f.getParent() +
                    "\n length: " + f.length() +
                    "\n lastModified: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(f.lastModified())
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
