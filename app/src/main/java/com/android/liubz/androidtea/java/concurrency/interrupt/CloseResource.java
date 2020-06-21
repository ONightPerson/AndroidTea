package com.android.liubz.androidtea.java.concurrency.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import static java.lang.System.out;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */

class Server {
    public static final int SERVER_PORT = 8080;

    private static volatile Server sInstance;

    private ServerSocket mSrvSocket;
    private ExecutorService mExecutors = Executors.newCachedThreadPool();

    private Server() {
        mExecutors.execute(new ServerInitTask());
    }

    public static Server getInstance() {
        if (sInstance == null) {
            synchronized (Server.class) {
                if (sInstance == null) {
                    sInstance = new Server();
                }
            }
        }
        return sInstance;
    }

    class ServerInitTask implements Runnable {

        @Override
        public void run() {
            createServer();
        }
    }

    public void createServer() {
        try {
            mSrvSocket = new ServerSocket(SERVER_PORT);
            Socket socket = mSrvSocket.accept();
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("hello client");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Client {

    private Socket mSocket;
    public void connect(String name, int port) {
        try {
            mSocket = new Socket(name, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public InputStream getInputStream() {
        try {
            return mSocket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

public class CloseResource {

    public static void main(String[] args) throws InterruptedException {

        Server.getInstance();
        TimeUnit.MILLISECONDS.sleep(200);
        Client client = new Client();
        client.connect("localhost", Server.SERVER_PORT);
        InputStream in = client.getInputStream();
        ExecutorService exec = Executors.newCachedThreadPool();
        Runnable ioTask = new IOTask(in);
        Future<?> pendingTask = exec.submit(ioTask);
        TimeUnit.SECONDS.sleep(3);

        out.println("interrupting " + ioTask.getClass().getName());
        pendingTask.cancel(true);
        out.println("interrupt send to " + ioTask.getClass().getName());


        TimeUnit.SECONDS.sleep(1);
        out.println("close input stream");
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("finish");

    }
}
