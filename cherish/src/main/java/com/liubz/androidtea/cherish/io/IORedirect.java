package com.liubz.androidtea.cherish.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class IORedirect {

    public static void main(String[] args) {
        PrintStream console = System.out;

        BufferedInputStream bis = null;
        PrintStream ps = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("/Users/liubaozhu/local_repo/" +
                    "AndroidTea/app/src/main/java/com/android/liubz/androidtea/java/io/Echo.java"));
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("test.out")));
            System.setIn(bis);
            System.setOut(ps);
            System.setErr(ps);

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
            System.setOut(console);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ps != null) {
                ps.close();
            }
        }
    }
}
