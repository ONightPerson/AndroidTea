package com.liubz.androidtea.network.websocket;

import org.json.JSONException;
import org.json.JSONObject;

import com.liubz.androidtea.R;
import com.liubz.androidtea.utils.CommonHandler;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by liubaozhu on 2021/4/1
 */
public class WebSocketActivity extends FragmentActivity implements CommonHandler.MessageHandler {
    private static final String TAG = "WebSocketActivity";

    private static final int MSG_REFRESH_TEXT = 1;

    private CommonHandler handler = new CommonHandler(this);
    private StringBuilder builder = new StringBuilder();
    private TextView mLogTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network_websocket);
        mLogTv = findViewById(R.id.show_log_tv);

        WebSocketHelper.setSocketIOCallBack(new WebSocketCallback() {
            @Override
            public void onOpen() {
                Log.d(TAG, "onOpen thread name: " + Thread.currentThread().getName());
                builder.append("onOpen thread name: ")
                        .append(Thread.currentThread().getName())
                        .append(System.lineSeparator());
                handler.sendEmptyMessage(MSG_REFRESH_TEXT);
            }

            @Override
            public void onMessage(@Nullable String msg) {
                Log.d(TAG, "onMessage thread name: " + msg);
                builder.append("onMessage msg: ")
                        .append(msg)
                        .append(System.lineSeparator());
                handler.sendEmptyMessage(MSG_REFRESH_TEXT);
            }

            @Override
            public void onClose() {
                Log.d(TAG, "onClose thread name: " + Thread.currentThread().getName());
                builder.append("onClose thread name: ")
                        .append(Thread.currentThread().getName())
                        .append(System.lineSeparator());
                handler.sendEmptyMessage(MSG_REFRESH_TEXT);
            }

            @Override
            public void onConnectError(@Nullable Throwable t) {
                Log.d(TAG, "onConnectError thread name: " + Thread.currentThread().getName());
                builder.append("onConnectError info: ")
                        .append(t)
                        .append(System.lineSeparator());
                handler.sendEmptyMessage(MSG_REFRESH_TEXT);
            }
        });
    }

    public void connect(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WebSocketHelper.connect();
            }
        }).start();
    }

    public void send(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WebSocketHelper.send(getMsg(9));
            }
        }).start();
    }

    public String getMsg(int type) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("cuid", "2222");
            jsonObject.put("l_cuid", "1111");
            jsonObject.put("req_id", String.valueOf(System.currentTimeMillis()));
            jsonObject.put("msg_type", type);
            jsonObject.put("msg_content", getMsgContent());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    private JSONObject getMsgContent() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("0", System.currentTimeMillis());
            jsonObject.put("1", System.currentTimeMillis() + 2356223L);
            jsonObject.put("2", "好好学习");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public void login(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                WebSocketHelper.send(getMsg(0));
            }
        }).start();
    }

    @Override
    public void handleMessage(Message msg) {
        Log.d(TAG, "msg: " + msg);
        if (msg.what == MSG_REFRESH_TEXT) {
            mLogTv.setText(builder.toString());
        }

    }

    public void clear(View view) {
        builder.setLength(0);
        mLogTv.setText("");
    }
}
