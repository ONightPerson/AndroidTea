package com.liubz.androidtea.network.socket;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPChatService extends Service {
    private static final String TAG = "TCPChatService";
    private boolean mIsServiceDisconnected = false;
    private final String[] mDefinedMessages = new String[]{
            "你好呀，哈哈",
            "请问你叫什么名字呀？",
            "今天天气不错，去哪儿玩呀？",
            "你知道吗？我可是可以和多人同时聊天的哦",
            "给你讲个笑话吧：据说爱笑的人运气不会太差，不知道真假。"
    };

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new TcpServer()).start();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        mIsServiceDisconnected = true;
        super.onDestroy();
    }

    private class TcpServer implements Runnable {
        @Override
        public void run() {
            // 使用 try-with-resources 自动管理 ServerSocket 的关闭
            try (ServerSocket serverSocket = new ServerSocket(8688)) {
                while (!mIsServiceDisconnected) {
                    try {
                        // 接受客户端请求
                        final Socket client = serverSocket.accept();
                        Log.d(TAG, "accept client connection");
                        new Thread(() -> {
                            try {
                                responseClient(client);
                            } catch (IOException e) {
                                Log.e(TAG, "responseClient failed", e);
                            }
                        }).start();
                    } catch (IOException e) {
                        if (!mIsServiceDisconnected) {
                            Log.e(TAG, "accept client connection failed", e);
                        }
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, "establish tcp server failed, port:8688", e);
            }
        }
    }

    private void responseClient(Socket client) throws IOException {
        // 使用 try-with-resources 管理输入输出流
        try (BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
             PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(client.getOutputStream())), true)) {
            
            out.println("欢迎来到聊天室！");

            while (!mIsServiceDisconnected) {
                String str = in.readLine();
                if (str == null) {
                    // 客户端断开连接
                    break;
                }
                Log.d(TAG, "msg from client: " + str);
                int i = new Random().nextInt(mDefinedMessages.length);
                String msg = mDefinedMessages[i];
                out.println(msg);
                Log.d(TAG, "send msg to client: " + msg);
            }
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                Log.e(TAG, "close client socket failed", e);
            }
            Log.d(TAG, "client disconnected.");
        }
    }
}
