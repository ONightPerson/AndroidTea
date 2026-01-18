package com.liubz.androidtea.network.socket;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.NonNull;

import com.liubz.androidtea.databinding.ActivitySocketTestBinding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SocketTestActivity extends Activity {
    private static final String TAG = "SocketTestActivity";
    private static final int MESSAGE_RECEIVE_NEW_MSG = 1;
    private static final int MESSAGE_SOCKET_CONNECTED = 2;

    private ActivitySocketTestBinding binding;
    private PrintWriter mPrintWriter;
    private Socket mClientSocket;

    @SuppressLint("HandlerLeak")
    private final Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case MESSAGE_RECEIVE_NEW_MSG:
                    binding.tvChatContent.append((String) msg.obj);
                    break;
                case MESSAGE_SOCKET_CONNECTED:
                    binding.btnSend.setEnabled(true);
                    binding.tvStatus.setText("服务器连接状态: 已连接");
                    binding.tvStatus.setTextColor(0xFF4CAF50); // 绿色
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySocketTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. 启动服务端 Service (它运行在 :socket 独立进程中)
        Intent intent = new Intent(this, TCPChatService.class);
        startService(intent);

        // 2. 开启线程建立 Socket 连接
        new Thread(this::connectTCPServer).start();

        // 3. 绑定发送逻辑
        binding.btnSend.setOnClickListener(v -> sendMessage());
    }

    private void sendMessage() {
        final String msg = binding.etMsg.getText().toString();
        if (!TextUtils.isEmpty(msg) && mPrintWriter != null) {
            // Socket 发送也必须在子线程
            new Thread(() -> mPrintWriter.println(msg)).start();
            
            binding.etMsg.setText("");
            String time = formatDateTime(System.currentTimeMillis());
            final String showedMsg = "我 " + time + ": " + msg + "\n";
            binding.tvChatContent.append(showedMsg);
        }
    }

    @Override
    protected void onDestroy() {
        if (mClientSocket != null) {
            try {
                mClientSocket.shutdownInput();
                mClientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onDestroy();
    }

    private void connectTCPServer() {
        Socket socket = null;
        // 循环重连，直到连接成功
        while (socket == null && !isFinishing()) {
            try {
                socket = new Socket("localhost", 8688);
                mClientSocket = socket;
                mPrintWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
                mHandler.sendEmptyMessage(MESSAGE_SOCKET_CONNECTED);
                Log.d(TAG, "Connect to TCP server success!");
            } catch (IOException e) {
                SystemClock.sleep(1000);
                Log.d(TAG, "Connect tcp server failed, retrying...");
            }
        }

        try {
            // 持续接收来自远程服务器（独立进程）的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (!isFinishing()) {
                String msg = br.readLine();
                if (msg != null) {
                    Log.d(TAG, "Receive msg from server: " + msg);
                    String time = formatDateTime(System.currentTimeMillis());
                    final String showedMsg = "机器人 " + time + ": " + msg + "\n";
                    mHandler.obtainMessage(MESSAGE_RECEIVE_NEW_MSG, showedMsg).sendToTarget();
                }
            }
            Log.d(TAG, "Client thread quit...");
            if (mPrintWriter != null) mPrintWriter.close();
            br.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SimpleDateFormat")
    private String formatDateTime(long time) {
        return new SimpleDateFormat("(HH:mm:ss)").format(new Date(time));
    }
}
