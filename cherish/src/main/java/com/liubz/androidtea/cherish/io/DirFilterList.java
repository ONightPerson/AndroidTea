package com.liubz.androidtea.cherish.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * author: created by liubaozhu on 2020/5/14
 * email: liubaozhu@baidu.com
 */
public class DirFilterList {

    public static void main(String[] args) {
        File path = new File("./app/src/main/java/com/android/liubz/androidtea/java/io/filelist");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        System.out.println("list: " + list + ", size: " + list.length);
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String fileName : list) {
            System.out.println("fileName: " + fileName);
        }
    }

    static class DirFilter implements FilenameFilter {

        private Pattern mPattern;

        public DirFilter(String suffix) {
            System.out.println("suffix: " + suffix);
            mPattern = Pattern.compile(suffix);
        }

        @Override
        public boolean accept(File dir, String name) {
            System.out.println("name: " + name);
            return mPattern.matcher(name).matches();
        }
    }
}
