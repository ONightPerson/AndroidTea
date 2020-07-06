package com.liubz.androidtea.cherish.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class StoreAndRecoverData {
    public static void main(String[] args) {
        storeAndRecoverData("hello");
    }

    private static void storeAndRecoverData(String fileName) {
        DataInputStream in = null;
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
            out.writeDouble(23.44);
            out.writeUTF("我是中国人");
            out.writeInt(456);
            out.writeBytes("hello");
            out.flush();
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
            System.out.println(in.readInt());
            System.out.println(in.readByte());
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
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
 }
