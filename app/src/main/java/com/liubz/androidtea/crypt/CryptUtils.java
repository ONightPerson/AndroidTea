package com.liubz.androidtea.crypt;

import java.util.Random;

/**
 * Created by liubaozhu on 2020/8/23
 */
public class CryptUtils {

    public static String getRandomString(int length) { //length表示生成字符串的长度
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static long getTimeStamp() {
        return System.currentTimeMillis();
    }
}
