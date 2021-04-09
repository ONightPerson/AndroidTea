package com.liubz.androidtea.communicate.eventbus;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import com.liubz.androidtea.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;

/**
 * Created by liubaozhu on 2021/4/9
 */
public class EventBusActivity extends Activity {

    private TextView mQueryResultTv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communicate_event_bus);
        initViews();

        registerEvent();
    }

    private void initViews() {
        mQueryResultTv = findViewById(R.id.query_result_tv);
    }

    private void registerEvent() {
        EventBus.getDefault().register(this);
    }

    private void unregisterEvent() {
        EventBus.getDefault().unregister(this);
    }

    public void queryData(View view) {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            EventBus.getDefault().post(new MessageEvent("hello"));
        }).start();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onQueryResultEvent(MessageEvent event) {
        mQueryResultTv.setText(event.getMsg());

    }

    @Override
    protected void onDestroy() {
        unregisterEvent();
        super.onDestroy();
    }

    public static class MessageEvent {
        private String msg;

        public MessageEvent(String msg) {
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
