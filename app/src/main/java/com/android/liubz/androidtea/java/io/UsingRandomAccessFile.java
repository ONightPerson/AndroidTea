package com.android.liubz.androidtea.java.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class UsingRandomAccessFile {

    public static void main(String[] args) {
        String filePath = "hello";
        writeFile(filePath);
        display(filePath);
        modify(filePath);
        display(filePath);
    }

    private static void writeFile(String name) {
        RandomAccessFile out = null;
        try {
            out = new RandomAccessFile(name, "rw");
            for (int i = 0; i < 7; i++) {
                out.writeDouble(i * 1.414);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void modify(String name) {
        RandomAccessFile out = null;
        try {
            out = new RandomAccessFile(name, "rw");
            out.seek(5 * Double.BYTES);
            out.writeDouble(4.222222);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void display(String name) {
        RandomAccessFile in = null;
        try {
            in = new RandomAccessFile(name, "r");
            for (int i = 0; i < 7; i++) {
                System.out.println(in.readDouble());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
