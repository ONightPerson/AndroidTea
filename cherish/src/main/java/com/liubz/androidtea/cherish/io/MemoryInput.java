package com.liubz.androidtea.cherish.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class MemoryInput {

    public static void main(String[] args) {
        try {
            formattedMemoryRead("app/src/main/" +
                    "java/com/android/liubz/androidtea/java/io/Directory.java");
        } catch (IOException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void memoryRead(String fileName) throws IOException {
        StringReader reader = new StringReader(BufferedInputFile.read(fileName));
        int c;
        while ((c = reader.read()) != -1) {
            System.out.print((char) c);
        }
    }

    public static void formattedMemoryRead(String fileName) throws IOException {
        DataInputStream in = new DataInputStream(
                new ByteArrayInputStream(BufferedInputFile.read(fileName).getBytes())
        );

        while (in.available() != 0) {
            System.out.print((char) in.readByte());
        }
    }
}
