package com.liubz.androidtea.cherish.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashUtils {

    private static final char[] HEXCHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    };

    public static void main(String[] args) {
        String md5 = md5String("jiajia");
        System.out.println("md5: " + md5);

    }

    /**
     * Encode the bytes with hex string (lower case)
     */
    public static String toHexString(byte[] data) {
        StringBuilder sb = new StringBuilder(data.length * 2);
        for (byte oneByte : data) {
            sb.append(HEXCHARS[(oneByte & 0xf0) >>> 4]);
            sb.append(HEXCHARS[oneByte & 0x0f]);
        }
        return sb.toString();
    }

    public static byte[] md5Bytes(byte[] data) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(data);
            return md5.digest();
        } catch (Throwable e) {
        }
        return null;
    }

    public static byte[] md5Bytes(String str) {
        return md5Bytes(str.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Compute MD5 digest with hex encoding (lower case)
     *
     * @return null may be returned if unexpected exceptions happen
     */
    public static String md5String(byte[] data) {
        byte[] md5 = md5Bytes(data);
        if (md5 != null) {
            return toHexString(md5);
        }
        return null;
    }

    /**
     * Compute MD5 digest with hex encoding (lower case)</p>
     * Using {@link String#getBytes(String)} with "UTF-8" to convert String to byte[]</p>
     *
     * @return null may be returned if unexpected exceptions happen
     */
    public static String md5String(String data) {
        return md5String(data.getBytes(StandardCharsets.UTF_8));
    }
}
