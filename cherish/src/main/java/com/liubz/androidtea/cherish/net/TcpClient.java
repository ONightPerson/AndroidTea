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
    private BufferedReader mReader;
    private BufferedWriter mWriter;

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient();
        client.init();

        client.startWriting();
        client.startReading();
    }

    private void init() throws IOException {
        mClient = new Socket( "192.168.3.104", 13333);
    }

    private void startWriting() throws IOException {
        OutputStream os = mClient.getOutputStream();
        mWriter = new BufferedWriter(new OutputStreamWriter(os));
        new Thread(new WriteTask(mWriter)).start();
    }

    private void startReading() throws IOException {
        InputStream is = mClient.getInputStream();
        mReader = new BufferedReader(new InputStreamReader(is));
        new Thread(new ReadTask(mReader)).start();
    }

    private static class ReadTask implements Runnable {
        private BufferedReader reader;

        public ReadTask(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            String line;
            while (true) {
                try {
                    if (!((line = reader.readLine()) != null)) {
                        break;
                    }
                    System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    private static class WriteTask implements Runnable {

        private BufferedWriter writer;

        public WriteTask(BufferedWriter writer) {
            this.writer = writer;
        }

        @Override
        public void run() {
            BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while (true) {
                try {
                    if (((line = localReader.readLine()) == null)) {
                        break;
                    }
                    writer.write(line);
                    writer.newLine();
                    writer.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
