package com.android.liubz.androidtea.java.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/**
 * author: created by liubaozhu on 2020/5/14
 * email: liubaozhu@baidu.com
 */
public class DirFilterList3 {

    public static void main(String[] args) {
        File path = new File("./app/src/main/java/com/android/liubz/androidtea/java/io/filelist");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new FilenameFilter() {
                Pattern pattern = Pattern.compile(args[0]);
                @Override
                public boolean accept(File dir, String name) {
                    System.out.println("FilenameFilter --> dir: " + dir + ", name: " + name);
                    return pattern.matcher(name).matches();
                }
            });
        }
        System.out.println("list: " + list + ", size: " + list.length);
        long size = 0;
        for (String fileName : list) {
            File file = new File(path, fileName);
            long length = file.length();
            System.out.println("fileName: " + fileName + ", length: " + length);
            size += length;
        }
        System.out.println("total size: " + size);
    }
}
