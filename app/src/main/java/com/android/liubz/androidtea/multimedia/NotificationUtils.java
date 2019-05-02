package com.android.liubz.androidtea.multimedia;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.android.liubz.androidtea.R;

public class NotificationUtils {
    private static final String TAG = "NotificationUtils";

    public static int NOTIFICATION_ID = 1;

    public static void sendNotification(Context context) {
        NotificationManager nm = (NotificationManager) context.getSystemService(
                Context.NOTIFICATION_SERVICE);
        Notification notification = new NotificationCompat.Builder(context, null)
                .setContentTitle(context.getString(R.string.notification_content_title))
                .setContentText(context.getString(R.string.notification_content_text))
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(),
                        R.mipmap.teapot))
                .build();
        nm.notify(NOTIFICATION_ID, notification);
        Log.i(TAG, "sendNotification: ");
    }
}
