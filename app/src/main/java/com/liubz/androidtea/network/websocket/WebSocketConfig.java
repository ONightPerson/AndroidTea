package com.liubz.androidtea.network.websocket;

import java.util.concurrent.TimeUnit;

import org.jetbrains.annotations.NotNull;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okio.ByteString;

public class WebSocketConfig extends WebSocketListener implements IWebSocketConfig {

    private static final String TAG = "WebSocketConfig";

    private String wsUrl;

    private WebSocket mSocket;

    private WebSocket mServerSocket;

    private MockWebServer mMockWebServer;

    private ConnectStatus mStatus;

    private final OkHttpClient mClient;

    public WebSocketConfig() {
        this.wsUrl = wsUrl;
        this.mClient = new OkHttpClient.Builder()
                .pingInterval(10, TimeUnit.SECONDS)
                .build();
    }

    @NonNull
    public ConnectStatus getStatus() {
        return mStatus;
    }

    @Override
    public void initConfig() {
        Log.d(TAG, "init config");
        startServer();
    }

    private void startServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mMockWebServer = new MockWebServer();
                MockResponse response = new MockResponse()
                        .withWebSocketUpgrade(new WebSocketListener() {
                            @Override
                            public void onOpen(@NotNull WebSocket webSocket, @NotNull Response response) {
                                super.onOpen(webSocket, response);
                                //有客户端连接时回调
                                Log.e(TAG, "服务器收到客户端连接成功回调：");
                                mServerSocket = webSocket;
                                mServerSocket.send("我是服务器，你好呀");
                            }

                            @Override
                            public void onMessage(@NotNull WebSocket webSocket, @NotNull String text) {
                                super.onMessage(webSocket, text);

                                Log.e(TAG, "服务器收到消息：" + text);
                            }

                            @Override
                            public void onClosed(@NotNull WebSocket webSocket, int code,
                                                 @NotNull String reason) {
                                super.onClosed(webSocket, code, reason);
                                Log.e(TAG, "onClosed：");
                            }
                        });

                mMockWebServer.enqueue(response);
            }
        }).start();
    }

    @Override
    public void connect() {
        //获取连接url，初始化websocket客户端
        wsUrl = "ws://" + mMockWebServer.getHostName() + ":" + mMockWebServer.getPort() + "/";
        Log.d(TAG, "wsUrl: " + wsUrl);

        //构造request对象
        Request request = new Request.Builder()
                .url(wsUrl)
                .build();

        mSocket = mClient.newWebSocket(request, this);
        mStatus = ConnectStatus.Connecting;
    }

    @Override
    public void reConnect() {
        if (mSocket != null) {
            mSocket = mClient.newWebSocket(mSocket.request(), this);
        }
    }

    @Override
    public void send(@NonNull String msg) {
        if (mSocket != null) {
            Log.d(TAG, "send： " + msg);
            mSocket.send(msg);
        }
    }

    public void cancel() {
        if (mSocket != null) {
            mSocket.cancel();
        }
    }

    public void close() {
        if (mSocket != null) {
            mSocket.close(1000, null);
        }
    }

    @Override
    public void onOpen(@Nullable WebSocket webSocket, @Nullable Response response) {
        super.onOpen(webSocket, response);
        Log.d(TAG, "onOpen");
        this.mStatus = ConnectStatus.Open;
        if (mSocketIOCallback != null) {
            mSocketIOCallback.onOpen();
        }
    }

    @Override
    public void onMessage(@Nullable WebSocket webSocket, @Nullable String text) {
        super.onMessage(webSocket, text);
        Log.d(TAG, "onMessage: " + text);
        if (mSocketIOCallback != null) {
            mSocketIOCallback.onMessage(text);
        }
    }

    @Override
    public void onMessage(@Nullable WebSocket webSocket, @Nullable ByteString bytes) {
        super.onMessage(webSocket, bytes);
    }

    @Override
    public void onClosing(@Nullable WebSocket webSocket, int code, @Nullable String reason) {
        super.onClosing(webSocket, code, reason);
        this.mStatus = ConnectStatus.Closing;
        Log.d(TAG, "onClosing");
    }

    @Override
    public void onClosed(@Nullable WebSocket webSocket, int code, @Nullable String reason) {
        super.onClosed(webSocket, code, reason);
        Log.d(TAG, "onClosed");
        this.mStatus = ConnectStatus.Closed;
        if (mSocketIOCallback != null) {
            mSocketIOCallback.onClose();
        }
    }

    @Override
    public void onFailure(@Nullable WebSocket webSocket, @Nullable Throwable t,
                          @Nullable Response response) {
        super.onFailure(webSocket, t, response);
        Log.d(TAG, "onFailure: " + t.toString());
        t.printStackTrace();
        this.mStatus = ConnectStatus.Canceled;
        if (mSocketIOCallback != null) {
            mSocketIOCallback.onConnectError(t);
        }
    }

    private WebSocketCallback mSocketIOCallback;

    public void setSocketIOCallBack(WebSocketCallback callBack) {
        mSocketIOCallback = callBack;
    }

    public void removeSocketIOCallBack() {
        mSocketIOCallback = null;
    }
}
