package com.liubz.androidtea.cherish.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2022/11/30 12:05 PM
 */
public class FileUtils {

    public static void closeStream(Closeable stream) {
        if (stream == null) {
            return;
        }
        try {
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
