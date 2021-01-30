package com.liubz.androidtea.cherish.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * author: created by liubaozhu on 2021/1/30
 * email: liubaozhu@baidu.com
 */
public class UdpSender {

    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(34444);
        byte[] buffer = "I'm zhuzi".getBytes();
        // 向局域网另一台主机192.168.3.104：13333 发送报文
        DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length,
                InetAddress.getByName("192.168.3.104"), 13333);
        long startTime = System.currentTimeMillis();
        ds.send(dp);
        System.out.println("send time: " + (System.currentTimeMillis() - startTime));
        ds.close();
    }
}
