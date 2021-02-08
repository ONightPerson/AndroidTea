package com.liubz.androidtea.cherish.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by liubaozhu on 2021/2/8
 */
public class SequenceInputStreamTest {

    public static void main(String[] args) {
        try {
            dealMultiInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void dealMultiInput() throws IOException {
        Vector<FileInputStream> vis = new Vector<>();
        vis.add(new FileInputStream("/Users/liubaozhu/Desktop/my_photo_1.jpg"));
        vis.add(new FileInputStream("/Users/liubaozhu/Desktop/my_photo_2.jpg"));
        vis.add(new FileInputStream("/Users/liubaozhu/Desktop/my_photo_3.jpg"));
        vis.add(new FileInputStream("/Users/liubaozhu/Desktop/my_photo_4.jpg"));
        vis.add(new FileInputStream("/Users/liubaozhu/Desktop/my_photo_5.jpg"));
        Enumeration<FileInputStream> enumeration = vis.elements();
        SequenceInputStream sis = new SequenceInputStream(enumeration);
        BufferedInputStream br = new BufferedInputStream(sis);
        PrintStream pw = new PrintStream(new FileOutputStream("/Users/liubaozhu/Desktop"
                + "/other_photo.jpg"), true);
        int len;
        byte[] buffer = new byte[1024];
        while ((len = br.read(buffer)) != -1) {
            pw.write(buffer, 0, len);
        }
        br.close();
        pw.close();
    }

    public static void fileSegmentation(File largeFile) throws IOException {
        if (largeFile == null) {
            return;
        }
        FileInputStream bis = new FileInputStream(largeFile);
        OutputStream bos;
        byte[] cache = new byte[1024 * 1024];
        int len;
        int part = 1;
        while ((len = bis.read(cache)) != -1) {
            bos = new FileOutputStream("/Users/liubaozhu/Desktop"
                            + "/my_photo_" + part++ + ".jpg");
            bos.write(cache, 0, len);
            bos.close();
        }
        bis.close();
    }
}
