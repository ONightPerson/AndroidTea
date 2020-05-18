package com.android.liubz.androidtea.java.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class BinaryFile {

    public static byte[] read(File bFile) throws IOException {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(bFile));
            byte[] data = new byte[bis.available()];
            bis.read(data);
            return data;
        } finally {
            if (bis != null) {
                bis.close();
            }
        }
    }

    public static byte[] read(String bFile) throws IOException {
        return read(new File(bFile).getAbsoluteFile());
    }


    public static void main(String[] args) {
        try {
            byte[] bytes = BinaryFile.read("/Users/liubaozhu/local_repo/AndroidTea/bin/com/" +
                    "android/liubz/androidtea/java/io/BufferedInputFIle.class");
            Map<Byte, Integer> map = new HashMap<>();
            for (byte b : bytes) {
                if (map.containsKey(b)) {
                    map.put(b, map.get(b) + 1);
                } else {
                    map.put(b, 1);
                }
            }

            for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
