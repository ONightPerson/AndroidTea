package com.liubz.androidtea.cherish.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * author: created by liubaozhu on 2021/1/30
 * email: liubaozhu@baidu.com
 */
public class UdpSender {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket ds = new DatagramSocket(34444);
        String line;
        while ((line = reader.readLine()) != null) {
            if ("over".equals(line)) {
                break;
            }
            byte[] buffer = line.getBytes();
            // 向局域网另一台主机192.168.3.104：13333 发送报文
            DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length,
                    InetAddress.getByName("192.168.3.104"), 13333);
            ds.send(dp);
        }
        ds.close();
    }
}
