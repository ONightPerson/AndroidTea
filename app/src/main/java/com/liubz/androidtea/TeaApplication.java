package com.liubz.androidtea;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.Log;

import com.liubz.androidtea.network.websocket.WebSocketConfig;
import com.liubz.androidtea.network.websocket.WebSocketHelper;
import com.liubz.androidtea.utils.NotificationUtils;
import com.liubz.androidtea.utils.ApplicationUtils;

import org.litepal.LitePal;

public class TeaApplication extends Application {
    private static final String TAG = "TeaApplication";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        ApplicationUtils.initApplication(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        LitePal.initialize(this);

        Log.i(TAG, "onCreate: pid: " + Process.myPid());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(NotificationUtils.CHANNEL_ID,
                    getString(R.string.notification_channel_default_name), NotificationManager.IMPORTANCE_LOW);
            channel.enableLights(false);
            channel.enableVibration(false);
            nm.createNotificationChannel(channel);
        }

        initHelper();
        initConfig();
    }

    private void initHelper() {
        WebSocketHelper.init(new WebSocketConfig());
    }

    private void initConfig() {
        WebSocketHelper.initConfig();
    }
}
