package com.liubz.androidtea.cherish.io;

import java.io.File;

/**
 * Created by liubaozhu on 2021/2/8
 */
public class FileTest {

    public static void main(String[] args) {
        final File file = new File("/Users/liubaozhu/Desktop/parent-debug");
        deleteDir(file);
    }

    public static void deleteDir(File file) {
        if (file == null) {
            return;
        }
        final File[] subFiles = file.listFiles();
        if (subFiles == null) {
            return;
        }
        for (File subFile : subFiles) {
            System.out.println("subFile: " + subFile);
            if (subFile.isDirectory()) {
                deleteDir(subFile);
            } else {
                subFile.delete();
            }
        }
        file.delete();
    }
}
