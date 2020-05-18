package com.android.liubz.androidtea.java.io;


import com.android.liubz.androidtea.java.Utils;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/**
 * author: created by liubaozhu on 2020/5/16
 * email: liubaozhu@baidu.com
 *
 * 编译：
 * 1. javac -cp /Users/liubaozhu/local_repo/ThinkingInJava/src/main/java/mindview.jar -d bin /Users/liubaozhu/local_repo/AndroidTea/app/src/main/java/com/android/liubz/androidtea/java/io/Directory.java
 * 2. java -cp bin com.android.liubz.androidtea.java.io.Directory
 */
public class Directory {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(walk("."));
        } else {
            for (String arg : args) {
                TreeInfo files = Directory.walk(arg, ".*\\.class");
                System.out.println("tree info: " + files);
                for (File f : files) {
                    try {
                        byte[] bytes = BinaryFile.read(f);
                        if (bytes != null) {
                            byte[] header = Arrays.copyOf(bytes, 4);
                            System.out.println(Utils.bytestoHex(header));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static File[] local(File dir, String regex) {
        if (dir == null) {
            return null;
        }
        return dir.listFiles(new FilenameFilter() {
            Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("listFiles dir: " + dir + ", name: " + name);
                File file = new File(name);
                System.out.println("getName: " + file.getName() + ", " + file.getAbsolutePath());
                return pattern.matcher(file.getName()).matches();
            }
        });
    }

    // 重载方法
    public static File[] local(String path, String regex) {
        return local(new File(path), regex);
    }

    public static TreeInfo walk(String start, String regex) {
        return recurseDirs(new File(start), regex);
    }

    public static TreeInfo walk(File start, String regex) {
        return recurseDirs(start, regex);
    }

    public static TreeInfo walk(File start) {
        return recurseDirs(start, ".*");
    }

    public static TreeInfo walk(String start) {
        return recurseDirs(new File(start), ".*");
    }

    private static TreeInfo recurseDirs(File start, String regex) {

        TreeInfo result = new TreeInfo();
        if (start == null) {
            return result;
        }
        for (File item : start.listFiles()) {
            if (item.isDirectory()) {
                result.dirs.add(item);
                result.addAll(recurseDirs(item, regex));
            } else if (item.getName().matches(regex)) {
                result.files.add(item);
            }
        }
        return result;
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<>();
        public List<File> dirs = new ArrayList<>();

        @Override
        public Iterator<File> iterator() {
            return files.iterator();
        }

        public void addAll(TreeInfo other) {
            if (other == null) {
                return;
            }
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        @Override
        public String toString() {
            return "dirs: " + PPrint.pformat(dirs) + "\n\nfiles: " + PPrint.pformat(files);
        }
    }
}
