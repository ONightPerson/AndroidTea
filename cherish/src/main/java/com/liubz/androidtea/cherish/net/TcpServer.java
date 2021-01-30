package com.liubz.androidtea.cherish.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author: created by liubaozhu on 2021/1/30
 * email: liubaozhu@baidu.com
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {
        // 建立TCP服务器，并监听13333 端口
        ServerSocket server = new ServerSocket(13333);
        Socket client = server.accept();
        InputStream is = client.getInputStream();
        byte[] buff = new byte[1024];
        int len = is.read(buff);
        System.out.println("data" + new String(buff, 0, len) + ", byte number: " + len);

        client.close();
        server.close();
    }
}
