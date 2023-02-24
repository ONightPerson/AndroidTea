package com.liubz.androidtea.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.HomeActivity;
import com.liubz.androidtea.R;
import com.liubz.androidtea.utils.NotificationUtils;

public class NewTaskActivity extends AppCompatActivity {
    private static final String TAG = "ThirdActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        setTitle("NewTaskActivity");
    }

    public void sendNotification(View view) {
//        Log.i(TAG, "sendNotification: ");
//        Notification notification = createNotification(this, NotificationUtils.CHANNEL_ID);
//        notification.icon = R.drawable.icon;
//        notification.tickerText = "hello";
//        notification.contentView =  new RemoteViews(getPackageName(),
//                R.layout.activity_home);
//        notification.contentIntent = PendingIntent.getActivity(this, 0,
//                new Intent(this, HomeActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
//        notification.when = 0;
//        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        manager.notify(2, notification);
        NotificationUtils.sendNotification(this);
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
