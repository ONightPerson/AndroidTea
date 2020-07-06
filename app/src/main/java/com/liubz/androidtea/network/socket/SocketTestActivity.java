package com.liubz.androidtea.network.socket;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.liubz.androidtea.R;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class SocketTestActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "SocketTestActivity";

    private Button mInterruptibleSocketBtn;
    private Button mBlockSocketBtn;
    private Button mCancelBtn;
    private Thread mConnectThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(TAG, "onCreate: begin");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_test);
        initViews();
        startServer();
        Log.e(TAG, "onCreate: end");
    }

    private void initViews() {
        mInterruptibleSocketBtn = findViewById(R.id.interruptible_socket);
        mBlockSocketBtn = findViewById(R.id.blocking_socket);
        mCancelBtn = findViewById(R.id.cancel_socket);

        mInterruptibleSocketBtn.setOnClickListener(this);
        mBlockSocketBtn.setOnClickListener(this);
        mCancelBtn.setOnClickListener(this);
    }

    private void startServer() {
        new Thread(new Server()).start();
    }

    private void connectInterruptibly() throws IOException {
        Log.i(TAG, "connectInterruptibly: \n");
        SocketChannel channel = SocketChannel.open(new InetSocketAddress(
                "localhost", 8189));
        Scanner in = new Scanner(channel);
        while (!Thread.currentThread().isInterrupted()) {
            if (in.hasNextLine()) {
                String line = in.nextLine();
                Log.i(TAG, "Reading : " + line);
            }
        }
        Log.i(TAG, "connectInterruptibly: is interrupted");
    }

    private void connectBlocking() throws IOException {
        Log.i(TAG, "connectBlocking: \n");
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress("localhost", 8189));
        Scanner in = new Scanner(socket.getInputStream());
        while (!Thread.currentThread().isInterrupted()) {
            if (in.hasNextLine()) {
                String line = in.nextLine();
                Log.i(TAG, "Reading : " + line);
            }
        }
        Log.i(TAG, "connectBlocking: is interrupted");
    }

    @Override
    public void onClick(View v) {
        if (v == mInterruptibleSocketBtn) {
            mInterruptibleSocketBtn.setEnabled(false);
            mBlockSocketBtn.setEnabled(false);
            mCancelBtn.setEnabled(true);

            mConnectThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        connectInterruptibly();
                    } catch (Exception e) {
                        Log.e(TAG, "connectInterruptibly: ", e);
                    } finally {
                        mInterruptibleSocketBtn.setEnabled(true);
                        mBlockSocketBtn.setEnabled(true);
                        mCancelBtn.setEnabled(false);
                    }
                }
            });
            mConnectThread.start();
        } else if (v == mBlockSocketBtn) {
            mInterruptibleSocketBtn.setEnabled(false);
            mBlockSocketBtn.setEnabled(false);
            mCancelBtn.setEnabled(true);

            mConnectThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        connectBlocking();
                    } catch (Exception e) {
                        Log.e(TAG, "connectBlocking: \n", e);
                    } finally {
                        mInterruptibleSocketBtn.setEnabled(true);
                        mBlockSocketBtn.setEnabled(true);
                        mCancelBtn.setEnabled(false);
                    }
                }
            });
            mConnectThread.start();
        } else if (v == mCancelBtn) {
            if (mConnectThread != null) {
                mConnectThread.interrupt();
                mCancelBtn.setEnabled(false);
            }
        }
    }
}
