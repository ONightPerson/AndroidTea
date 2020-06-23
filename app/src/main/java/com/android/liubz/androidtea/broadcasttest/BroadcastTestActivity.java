package com.android.liubz.androidtea.broadcasttest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;

public class BroadcastTestActivity extends Activity {

    private NetworkBroadcastReceiver mNetBR;

    private class NetworkBroadcastReceiver extends BroadcastReceiver {
        private static final String TAG = "NetworkBroadcastReceive";

        @Override
        public void onReceive(Context context, Intent intent) {

            String action = intent.getAction();
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
                if (intent != null) {
                    ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo info = manager.getActiveNetworkInfo();
                    Log.i(TAG, "onReceive: info --> " + info);
                }
            }
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerReceiver();
    }

    private void registerReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        mNetBR = new NetworkBroadcastReceiver();
        registerReceiver(mNetBR, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mNetBR);
    }
}
