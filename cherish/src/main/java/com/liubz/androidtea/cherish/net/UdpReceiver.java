package com.liubz.androidtea.cherish.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * author: created by liubaozhu on 2021/1/30
 * email: liubaozhu@baidu.com
 */
public class UdpReceiver {

    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(13333);
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        System.out.println("waiting receiving");
        long startTime = System.currentTimeMillis();
        socket.receive(packet);
        System.out.println("finish receiving packet, time: "
                + (System.currentTimeMillis() - startTime));
        String ip = packet.getAddress().getHostAddress();
        byte[] data = packet.getData();
        System.out.println("data size: " + data.length);
        String content = new String(packet.getData(), 0, packet.getLength());
        int port = packet.getPort();
        System.out.println(ip + ":" + port + ", data: " + content);

        socket.close();
    }
}
