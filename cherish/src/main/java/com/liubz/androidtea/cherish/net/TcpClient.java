package com.liubz.androidtea.cherish.net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * author: created by liubaozhu on 2021/1/30
 * email: liubaozhu@baidu.com
 */
public class TcpClient {

    private Socket mClient;

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient();
        client.init();

        client.startWriting();
        client.startReading();
    }

    private void init() throws IOException {
        mClient = new Socket( "192.168.3.104", 13333);
    }

    private void startWriting() {

        new Thread(new WriteTask(mClient)).start();
    }

    private void startReading() {
        new Thread(new ReadTask(mClient)).start();
    }

    private static class ReadTask implements Runnable {
        private Socket client;

        public ReadTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                doRead();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void doRead() throws IOException {
            InputStream is = client.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line;
            while (!client.isClosed() && ((line = reader.readLine()) != null)) {
                System.out.println(line);
            }
        }
    }

    private static class WriteTask implements Runnable {

        private final Socket client;

        public WriteTask(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            try {
                doWrite();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void doWrite() throws IOException {
            OutputStream os = client.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (((line = localReader.readLine()) != null)) {
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
            localReader.close();
            writer.close();
            client.close();
        }
    }
}
