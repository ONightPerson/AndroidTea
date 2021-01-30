package com.liubz.androidtea.cherish.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * author: created by liubaozhu on 2021/1/30
 * email: liubaozhu@baidu.com
 */
public class TcpClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.3.104", 13333);
        OutputStream os = client.getOutputStream();
        os.write("您好".getBytes());
        client.close();
    }
}
