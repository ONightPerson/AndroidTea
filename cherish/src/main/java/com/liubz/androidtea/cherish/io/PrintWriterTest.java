package com.liubz.androidtea.cherish.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Created by liubaozhu on 2021/2/8
 */
public class PrintWriterTest {

    public static void main(String[] args) {
        try {
            println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, false);
        String line;
        while ((line = br.readLine()) != null) {
            pw.println(line);
            pw.flush();
        }
        br.close();
        pw.close();
    }
}
