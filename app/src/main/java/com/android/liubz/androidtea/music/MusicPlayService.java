package com.android.liubz.androidtea.music;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import com.android.liubz.androidtea.music.aidl.MusicManagerService;

public class MusicPlayService extends Service {
    private static final String TAG = "MusicPlayService";

    public MusicPlayService() {
        Log.i(TAG, "MusicPlayService: Construct");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        createChannel(this, "mychanel", NotificationManager.IMPORTANCE_HIGH, "推送");
        startForeground(1, createNotification(this, "mychanel"));
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopSelf();
        }).start();
    }

    public static Notification createNotification(Context ctx, String channelId) {
        Notification notification;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder builder = new Notification.Builder(ctx, channelId);
            notification = builder.build();
        } else {
            notification = new Notification();
        }
        return notification;
    }

    public static void createChannel(Context cxt, String channelId, int importance,
                                     String name) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationManager nm = (NotificationManager) cxt.getSystemService(
                    Context.NOTIFICATION_SERVICE);
            NotificationChannel channel = new NotificationChannel(channelId, name, importance); // low 不提示声音
            channel.enableLights(false);
            channel.enableVibration(false);
            nm.createNotificationChannel(channel);
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new MusicManagerService();
    }
}
