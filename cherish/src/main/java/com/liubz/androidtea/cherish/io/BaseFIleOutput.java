package com.liubz.androidtea.cherish.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class BaseFIleOutput {

    public static void main(String[] args) {
        output("/Users/liubaozhu/Downloads/ideaIC-2020.1.1.dmg",
                "hello.java");
    }

    public static void output(String inFile, String outFile) {
        LineNumberReader in = null;
        PrintWriter out = null;
        try {
            in = new LineNumberReader(new FileReader(inFile));
            out = new PrintWriter(outFile);
            String line;
            int lineCount = 0;
            long start = System.currentTimeMillis();
            while ((line = in.readLine()) != null) {
                out.println(in.getLineNumber() + ": " + line);
            }
            System.out.println("耗时： " + (System.currentTimeMillis() - start));
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
                out.close();
            }
        }
    }
}
