package com.android.liubz.androidtea.java.decrypt;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by liubaozhu on 2019-11-13
 */
public class DecryptUtils {
    private static final String TAG = "DecryptUtils";
    private static final String CipherMode = "AES/CFB/NoPadding";
    private static final String CN_TXT = "/Users/liubaozhu/CommonRepo/AndroidTea/app/src/main/java/com/android/liubz/androidtea/java/decrypt/cn.txt";


    public static void main(String[] args) {
//        decryptData(null);
        System.out.println(Character.digit('A', 16));
    }


    public static void decryptData(Context cxt) {
        try {
            String data = getData(cxt);
//            Log.i(TAG, "decryptData --> data: " + data);
            JSONArray json = new JSONArray(decrypt("hujian1234567890", data));
//            Log.i(TAG, "decryptData --> json:" + json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static String getData(Context cxt) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
//            BufferedReader bf = new BufferedReader(new InputStreamReader(
//                    cxt.getAssets().open("cn.txt")));
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    new FileInputStream(CN_TXT)));
            while (true) {
                String line = bf.readLine();
                if (line == null) {
                    break;
                }
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    public static String decrypt(String key, String data) {
        try {
            System.out.println("charset: " + Charset.defaultCharset());
//            Log.i(TAG, "decrypt: charset: " + Charset.defaultCharset());
            byte[] encrypted1 = Base64.decode(data.getBytes(), 0);
            Cipher cipher = Cipher.getInstance(CipherMode);
            cipher.init(2, new SecretKeySpec(key.getBytes(), "AES"),
                    new IvParameterSpec(new byte[cipher.getBlockSize()]));
            return new String(cipher.doFinal(encrypted1), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
