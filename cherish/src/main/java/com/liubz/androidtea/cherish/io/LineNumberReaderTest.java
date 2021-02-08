package com.liubz.androidtea.cherish.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

/**
 * Created by liubaozhu on 2021/2/3
 */
public class LineNumberReaderTest {

    public static void main(String[] args) {
        try {
            readAndWriteWithLineNumber();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readAndWriteWithLineNumber() throws IOException {
        FileReader fr = new FileReader("/Users/liubaozhu/Documents"
                + "/工具/抓包配置/network_security_config.xml");
        LineNumberReader lnr = new LineNumberReader(fr);
        lnr.setLineNumber(5);
        String line;
        while ((line = lnr.readLine()) != null) {
            int lineNumber = lnr.getLineNumber();
            System.out.println(lineNumber + " " + line);
        }
        lnr.close();
    }
}
