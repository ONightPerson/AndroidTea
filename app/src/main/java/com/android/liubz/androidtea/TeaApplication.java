package com.android.liubz.androidtea;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import androidx.multidex.MultiDex;
import android.util.Log;

import com.android.liubz.androidtea.modules.multimedia.NotificationUtils;
import com.android.liubz.androidtea.utils.ApplicationUtils;

import org.litepal.LitePal;

public class TeaApplication extends Application {
    private static final String TAG = "TeaApplication";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
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


    }
}
