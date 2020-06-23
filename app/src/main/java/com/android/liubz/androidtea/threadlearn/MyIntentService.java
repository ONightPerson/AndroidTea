package com.android.liubz.androidtea.threadlearn;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {
    private static final String TAG = "MyIntentService";


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: flags: " + flags + ", startId: " + startId
                + ", redelivery: " + (flags & START_FLAG_REDELIVERY));
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action = intent.getStringExtra("task_action");
        Log.i(TAG, "receive action: " + action);
        SystemClock.sleep(1000);
        Log.i(TAG, "handle action: " + action);

    }
}
