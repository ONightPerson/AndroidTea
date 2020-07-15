package com.liubz.androidtea.cherish;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liubaozhu on 2019-12-16
 */
public class Utils {

    /**
     * 将二进制数组转化为十六进制表示
     */
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] data) {
        char[] result = new char[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            int item = data[i] & 0xFF;
            result[i * 2] = HEX_ARRAY[item >>> 4];
            result[i * 2 + 1] = HEX_ARRAY[item & 0x0F];
        }
        return new String(result);
    }

    public static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] result = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            result[i / 2] = (byte) (Character.digit(hex.charAt(i), 16) << 4 + Character.digit(hex.charAt(i+1), 16));
        }
        return result;
    }

    public static String convertUrlToFilename(String str) {
        // 只允许字母和数字
        String regEx = "[^a-zA-Z0-9]";
        // 清除掉所有特殊字
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

    public static void main(String[] args) {
        System.out.println(convertUrlToFilename("http://fewfefe.jpg"));
    }
}
