package com.android.liubz.androidtea.java.concurrent;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by liubaozhu on 2019-11-04
 */
public class CopyOnWriteArrayListTest {
    static CopyOnWriteArrayList sCopyList = new CopyOnWriteArrayList();

    public static void main(String[] args) throws InterruptedException {
//        sCopyList.add("hello");
//        sCopyList.add("world");
//        sCopyList.add("i'm");
//        sCopyList.add("a");
//        sCopyList.add("superman");
//        sCopyList.add("nice to");
//        sCopyList.add("meet you");
//
//        Thread thread = new Thread(() -> {
//            sCopyList.set(1, "baba");
//            sCopyList.remove(2);
//            sCopyList.remove(3);
//            System.out.println("child thread has done");
//        });
//
//        Iterator iterator = sCopyList.iterator();
//        thread.start();
//        thread.join();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        try {
            hello(false);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("yanzhen");
        }

    }


    public static void hello(boolean hi) throws IOException {
        System.out.println("hello");
        if (hi) {
            throw new IOException();
        }
    }
}
