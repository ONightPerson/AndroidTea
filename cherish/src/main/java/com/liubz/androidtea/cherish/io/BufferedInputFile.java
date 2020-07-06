package com.liubz.androidtea.cherish.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * author: created by liubaozhu on 2020/5/17
 * email: liubaozhu@baidu.com
 */
public class BufferedInputFile {

    public static void main(String[] args) {
//        System.out.println(read("/Users/liubaozhu/local_repo/AndroidTea/app/src/main/java/com" +
//                "/android/liubz/androidtea/java/io/DirFilterList.java"));

        if (args.length < 2) {
            System.out.println("Please specify a file path and a word");
            return;
        }
        LinkedList<String> stack = readToLinkedList(args[0], args[1]);
        while (!stack.isEmpty()) {
            System.out.print(stack.removeLast());
        }
    }

    public static String read(String fileName){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line + "\n");
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static LinkedList<String> readToLinkedList(String fileName){
        BufferedReader reader = null;
        LinkedList<String> stack = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                stack.offer(line.toUpperCase() + "\n");
            }
            return stack;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stack;
    }

    private static LinkedList<String> readToLinkedList(String fileName, String find){
        BufferedReader reader = null;
        LinkedList<String> stack = new LinkedList<>();
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(find)) {
                    stack.offer(line + "\n");
                }
            }
            return stack;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stack;
    }
}
