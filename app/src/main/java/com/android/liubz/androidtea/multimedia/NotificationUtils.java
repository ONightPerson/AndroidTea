package com.android.liubz.androidtea.multimedia;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.android.liubz.androidtea.R;
import network.NetworkTestActivity;

public class NotificationUtils {
    private static final String TAG = "NotificationUtils";

    public static int NOTIFICATION_ID = 33;
    public static final String CHANNEL_ID = "20019";

    public static void sendNotification(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE);
        Log.i(TAG, "sendNotification: " + Build.VERSION.SDK_INT);
        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(context.getString(R.string.notification_content_title))
                .setContentText(context.getString(R.string.notification_content_text))
                .setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, NetworkTestActivity.class), PendingIntent.FLAG_UPDATE_CURRENT))
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setOngoing(true)
                .setSmallIcon(R.drawable.my_ic_launcher)
                .build();
        nm.notify(NOTIFICATION_ID, notification);

        Log.i(TAG, "sendNotification: ");
    }
}
