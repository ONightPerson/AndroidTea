package com.android.liubz.androidtea.java.tools;

import java.io.File;
import java.text.SimpleDateFormat;

/**
 * Created by liubaozhu on 2020-04-05
 */

public class LastMotifiedTest {

    public static void main(String[] args) {

        System.out.println("--------------------");
        // Read the file
        File file = new File("/Users/liubaozhu/baidu/mobilesecurity/YhdsSafeUrl/app/build/outputs/apk/release/app-release.apk");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateFormat = sdf.format(file.lastModified());

        System.out.println("Time in date format: " + dateFormat);
        System.out.println("-----------------");

    }

}
