package com.liubz.androidtea.cherish.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by liubaozhu on 2021/1/28
 */
public class NetUtils {

    public static void main(String[] args) throws UnknownHostException {
//        getLocalHost();
        getWanHost();
    }

    public static void getLocalHost() throws UnknownHostException {
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println("ia: " + ia);
        System.out.println("name: " + ia.getHostName());
        System.out.println("address: " + ia.getHostAddress());
    }

    public static void getWanHost() throws UnknownHostException {
        InetAddress[] iaArr = InetAddress.getAllByName("www.baidu.com");
        for (InetAddress ia : iaArr) {
            System.out.println("ia: " + ia);
            System.out.println("name: " + ia.getHostName());
            System.out.println("address: " + ia.getHostAddress());
            System.out.println("--------------------\n");
        }
    }
}
