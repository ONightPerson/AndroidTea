package com.liubz.androidtea.container;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.utils.ThreadUtils;

import java.util.concurrent.SynchronousQueue;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/16 6:56 PM
 */
public class ContainerActivity extends BaseActivity {
    private static final String TAG = "ContainerActivity";

    final SynchronousQueue<Integer> queue = new SynchronousQueue<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        ButterKnife.bind(this);
        synchronousQueue();
    }

    @OnClick(R.id.synchronous_queue)
    void synchronousQueue() {
        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "put thread start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "put thread end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "take thread start");
                try {
                    Log.i(TAG, "take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.i(TAG, "take thread end");
            }
        });
        putThread.start();
        ThreadUtils.sleep(1000);
        takeThread.start();
    }
}
