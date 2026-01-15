package com.liubz.androidtea.utils;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.liubz.androidtea.R;

public class NotificationUtils {

    private static final String CHANNEL_ID = "default_channel";
    private static final String CHANNEL_NAME = "Default Channel";

    /**
     * 发送一条简单的通知
     *
     * @param context 上下文
     * @param title   通知标题
     * @param content 通知内容
     * @param id      通知 ID (用于区分不同的通知)
     */
    public static void sendNotification(Context context, String title, String content, int id) {
        createNotificationChannel(context);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher) // 设置小图标
                .setContentTitle(title)              // 设置标题
                .setContentText(content)            // 设置内容
                .setPriority(NotificationCompat.PRIORITY_DEFAULT) // 设置优先级
                .setAutoCancel(true);               // 点击后自动消失

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        
        // 检查权限并发送通知 (对于 API 33+ 需要动态申请 POST_NOTIFICATIONS 权限，此处仅执行发送操作)
        notificationManager.notify(id, builder.build());
    }

    /**
     * 创建通知渠道 (适配 Android 8.0+)
     */
    private static void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription("Default notification channel");
            
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            if (manager != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }
}
