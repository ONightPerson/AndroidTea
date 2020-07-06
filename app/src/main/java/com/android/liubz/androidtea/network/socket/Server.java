package com.android.liubz.androidtea.network.socket;

import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private static final String TAG = "Server";
    @Override
    public void run() {
        try {
            Log.i(TAG, "start server:\n");
            ServerSocket server = new ServerSocket(8189);
            while (true) {
                Socket fromClientSo = server.accept();
                Runnable task = new EchoHandlerTask(fromClientSo);
                Thread t = new Thread(task);
                t.start();
            }
        } catch (IOException e) {
            Log.e(TAG, "Server.run exception: \n", e);
        }
    }

    private static class EchoHandlerTask implements Runnable {
        private Socket inComing;
        private int counter;


        public EchoHandlerTask(Socket s) {
            inComing = s;
        }

        @Override
        public void run() {
            try {
                OutputStream os = inComing.getOutputStream();
                PrintWriter out = new PrintWriter(os, true);

                while (counter <= 100) {
                    counter++;
                    if (counter < 10) {
                        out.println(counter);
                        Log.i(TAG, "server output number: " + counter);
                    }
                    Thread.sleep(100);
                }
            } catch (IOException ioe) {
                Log.e(TAG, "EchoHandlerTask : \n", ioe);
                ioe.printStackTrace();
            } catch (InterruptedException e) {
                Log.e(TAG, "EchoHandlerTask: \n", e);
            } finally {
                try {
                    inComing.close();
                } catch (IOException e) {
                    Log.e(TAG, "incoming close ex: ", e);
                }
            }

        }
    }
}
