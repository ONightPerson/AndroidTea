package com.liubz.androidtea.interprocess;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import com.liubz.androidtea.R;

public class ThirdActivity extends Activity {
    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_test);
    }

    public void sendNotification(View view) {
        Log.i(TAG, "sendNotification: ");
        Notification notification = createNotification(this,"200001");
        notification.icon = R.drawable.icon;
        notification.tickerText = "hello";
        notification.contentView =  new RemoteViews(getPackageName(),
                R.layout.home_activity);
        notification.contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, ThirdActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
        notification.when = 0;
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, notification);
//        NotificationUtils.sendNotification(this);
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
}
