package com.android.liubz.androidtea.java.io;

import java.io.File;
import java.io.IOException;

/**
 * author: created by liubaozhu on 2020/5/16
 * email: liubaozhu@baidu.com
 */
public class ProcessFiles {

    public static void main(String[] args) {
        ProcessFiles proFiles = new ProcessFiles(new Strategy() {
            @Override
            public void process(File file) {
                System.out.println(file);
            }
        }, "java");
        try {
            if (args.length == 0) {
                proFiles.walk(new File("."));
            } else {
                for (String arg : args) {
                    proFiles.walk(new File(arg));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface Strategy {
        void process(File file);
    }

    private Strategy mStrategy;
    private String mExt;

    public ProcessFiles(Strategy strategy, String ext) {
        mStrategy = strategy;
        mExt = ext;
    }

    public void walk(File file) throws IOException {
        if (file == null) {
            return;
        }

        if (file.isDirectory()) {
            processDir(file);
        } else if (file.getName().endsWith("." + mExt)) {
            mStrategy.process(file.getCanonicalFile());
        }
    }

    private void processDir(File root) {
        if (root == null) {
            return;
        }

        for (File file : Directory.walk(root.getAbsolutePath(), ".*\\." + mExt)) {
            mStrategy.process(file);
        }
    }
}
