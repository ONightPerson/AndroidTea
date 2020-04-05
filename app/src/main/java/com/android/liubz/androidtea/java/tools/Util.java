/*
 * Copyright (C) 2013 Baidu Inc. All rights reserved.
 */
package com.android.liubz.androidtea.java.tools;

import android.app.Activity;
import android.content.pm.ApplicationInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 工具类
 * 
 * @since 2013-5-22
 */
public final class Util {

    public static void main(String[] args) {
        try {
            System.out.println(readApkModifyTime(new FileInputStream(new File("/Users/liubaozhu/baidu/mobilesecurity/YhdsSafeUrl/app/build/outputs/apk/release/app-release.apk"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static ApplicationInfo sAppInfo = null;

    private static Map<String, WeakReference<Activity>> startContextMap = new HashMap<>();

    /**
     * 构造函数
     */
    private Util() {
        // empty
    }
    
    /**
     * 读取 apk 文件的最后修改时间（生成时间），通过编译命令编译出来的apk第一个 entry 为 
     * META-INF/MANIFEST.MF  所以我们只读取此文件的修改时间可以。
     * 
     * 对于 eclipse 插件打包的 apk 不适用。文件 entry顺序不确定。
     * 
     * @param fis 
     * @throws IOException 
     * @return 返回 {@link SimpleDateTime}
     */
    public static SimpleDateTime readApkModifyTime(InputStream fis) throws IOException {
        
        int LOCHDR = 30; //header 部分信息截止字节 // SUPPRESS CHECKSTYLE
        int LOCVER = 4; //排除掉magic number 后的第四个字节，version部分 // SUPPRESS CHECKSTYLE
        int LOCTIM = 10; //最后修改时间 第10个字节。 // SUPPRESS CHECKSTYLE
        
        byte[] hdrBuf = new byte[LOCHDR - LOCVER];
        
        // Read the local file header.
        byte[] magicNumer = new byte[4]; // SUPPRESS CHECKSTYLE magic number
        fis.read(magicNumer);
        fis.read(hdrBuf, 0, hdrBuf.length);
        
        int time = peekShort(hdrBuf, LOCTIM - LOCVER);
        int modDate = peekShort(hdrBuf, LOCTIM - LOCVER + 2);
        
        SimpleDateTime cal = new SimpleDateTime();
        /*
         * zip中的日期格式为 dos 格式，从 1980年开始计时。
         */
        cal.set(1980 + ((modDate >> 9) & 0x7f), ((modDate >> 5) & 0xf), // SUPPRESS CHECKSTYLE magic number
                modDate & 0x1f, (time >> 11) & 0x1f, (time >> 5) & 0x3f, // SUPPRESS CHECKSTYLE magic number
                (time & 0x1f) << 1);  // SUPPRESS CHECKSTYLE magic number
        
        fis.skip(0);
        
        return cal;
    }

    /**
     * 从buffer数组中读取一个 short。
     * @param buffer buffer数组
     * @param offset 偏移量，从这个位置读取一个short。
     * @return short值
     */
    private static int peekShort(byte[] buffer, int offset) {
        short result = (short) ((buffer[offset + 1] << 8) | (buffer[offset] & 0xff)); // SUPPRESS CHECKSTYLE magic number

        return result & 0xffff; // SUPPRESS CHECKSTYLE magic number
    }
}
