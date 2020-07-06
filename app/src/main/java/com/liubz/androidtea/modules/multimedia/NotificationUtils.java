package com.liubz.androidtea.modules.multimedia;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.liubz.androidtea.R;
import com.liubz.androidtea.interprocess.SecondActivity;

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
                .setContentIntent(PendingIntent.getActivity(context, 0, new Intent(context, SecondActivity.class), PendingIntent.FLAG_UPDATE_CURRENT))
                .setWhen(System.currentTimeMillis())
                .setAutoCancel(true)
                .setOngoing(true)
                .setSmallIcon(R.drawable.my_ic_launcher)
                .build();
        nm.notify(NOTIFICATION_ID, notification);

        Log.i(TAG, "sendNotification: ");
    }
}
