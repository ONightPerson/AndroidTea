package com.android.liubz.androidtea.java.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class Echo {

    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {
            while ((line = stdin.readLine()) != null && line.length() != 0) {
                System.out.println(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
