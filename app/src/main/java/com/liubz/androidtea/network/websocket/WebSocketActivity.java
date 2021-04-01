package com.liubz.androidtea.network.websocket;

import org.json.JSONException;
import org.json.JSONObject;

import com.liubz.androidtea.R;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * Created by liubaozhu on 2021/4/1
 */
public class WebSocketActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.network_websocket);
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
            jsonObject.put("0", "1111");
            jsonObject.put("1", "2222");
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
}
