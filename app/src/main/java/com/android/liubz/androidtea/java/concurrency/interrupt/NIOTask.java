package com.android.liubz.androidtea.java.concurrency.interrupt;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static java.lang.System.out;

/**
 * author: created by liubaozhu on 2020/6/21
 * email: liubaozhu@baidu.com
 */
public class NIOTask implements Runnable {

    private final SocketChannel mSocketChannel;

    public NIOTask(SocketChannel socketChannel) {
        mSocketChannel = socketChannel;
    }

    @Override
    public void run() {

        try {
            out.println("Waiting for read() in " + this);

            int num;
            while ((num = mSocketChannel.read(ByteBuffer.allocate(1))) != 0) {
                out.println("num: " + num);
            }
        } catch (ClosedByInterruptException e) {
            out.println("ClosedByInterruptException");
        } catch (AsynchronousCloseException e) {
            out.println("AsynchronousCloseException");
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("Exiting NIOBlocked.run() " + this);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Server server = Server.getInstance();
//        ServerSocket server = new ServerSocket(8080);

        InetSocketAddress isa = new InetSocketAddress("localhost", Server.SERVER_PORT);
        SocketChannel sc1 = SocketChannel.open(isa);
        SocketChannel sc2 = SocketChannel.open(isa);

        Future<?> f = exec.submit(new NIOTask(sc1));
        exec.execute(new NIOTask(sc2));
        exec.shutdown();

        TimeUnit.SECONDS.sleep(1);
        f.cancel(true);
        TimeUnit.SECONDS.sleep(1);
        sc2.close();
    }
}
