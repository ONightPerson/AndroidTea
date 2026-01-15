package com.liubz.androidtea.notification;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
        NotificationUtils.sendNotification(this, "hello", "world", 1);
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
