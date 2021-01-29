package com.liubz.androidtea.cherish.classloader;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by liubaozhu on 2021/1/28
 */
public class CypherUtils {

    public static void cypher(InputStream ips, OutputStream ops) throws IOException {
        int b = -1;
        while ((b = ips.read()) != -1) {
            //1 就变成 0，0 就变成 1
            ops.write(b ^ 0xff);
        }
    }
}
