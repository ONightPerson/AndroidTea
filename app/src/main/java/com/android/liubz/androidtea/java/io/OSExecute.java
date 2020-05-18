package com.android.liubz.androidtea.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class OSExecute {

    public static void main(String[] args) {
        command("javac /Users/liubaozhu/local_repo/AndroidTea/app/src/main/java/com/android/liubz/androidtea/java/io/OSExecute.java");
    }

    public static void command(String command) {
        boolean err = false;

        Process process;
        BufferedReader result = null;
        BufferedReader errors = null;
        try {
            process = new ProcessBuilder(command.split(" ")).start();
            result = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ((s = result.readLine()) != null) {
                System.out.println(s);
            }

            errors = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            while ((s = errors.readLine()) != null) {
                System.err.println(s);
                err = true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (result != null) {
                try {
                    result.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (errors != null) {
                try {
                    errors.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (err) {
            throw new RuntimeException("Errors executing " + command);
        }
    }
}
