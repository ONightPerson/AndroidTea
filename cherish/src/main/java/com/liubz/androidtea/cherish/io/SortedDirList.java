package com.liubz.androidtea.cherish.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * author: created by liubaozhu on 2020/5/16
 * email: liubaozhu@baidu.com
 */
public class SortedDirList {

    private String mPath;
    public SortedDirList(String path) {
        mPath = path;
    }

    public String[] list() {
        String[] list = new File(mPath).list();
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        return list;
    }

    public String[] list(String regex) {
        String[] list = new File(mPath).list(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        return list;
    }
}
