package com.liubz.androidtea.cherish.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: created by liubaozhu on 2021/1/30
 * email: liubaozhu@baidu.com
 */
public class TcpServer {

    public static void main(String[] args) throws IOException {

        ExecutorService service = Executors.newFixedThreadPool(5);
        // 建立TCP服务器，并监听13333 端口
        ServerSocket server = new ServerSocket(13333);
        Socket client = server.accept();
        service.execute(new IOTask(client));
    }

    private static class IOTask implements Runnable {

        private Socket client;

        public IOTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                doTask();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void doTask() throws IOException {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String line;
            while (((line = reader.readLine()) != null)) {
                System.out.println(line);
                writer.write("收到你的消息：\"" + line + "\".");
                writer.newLine();
                writer.flush();
            }
            writer.close();
            reader.close();
            client.close();
        }
    }
}
