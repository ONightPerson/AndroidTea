package com.liubz.androidtea;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liubz.androidtea.network.websocket.WebSocketConfig;
import com.liubz.androidtea.network.websocket.WebSocketHelper;
import com.liubz.androidtea.utils.ApplicationUtils;
import com.liubz.androidtea.utils.CrashHandler;

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

        initHelper();
        initConfig();
        CrashHandler.getInstance().init(this);

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Log.i(TAG, activity.getClass().getSimpleName() + " onCreate");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {
                Log.i(TAG, activity.getClass().getSimpleName() + " onStart");
            }

            @Override
            public void onActivityResumed(@NonNull Activity activity) {
                Log.i(TAG, activity.getClass().getSimpleName() + " onResume");
            }

            @Override
            public void onActivityPaused(@NonNull Activity activity) {
                Log.i(TAG, activity.getClass().getSimpleName() + " onPause");
            }

            @Override
            public void onActivityStopped(@NonNull Activity activity) {
                Log.i(TAG, activity.getClass().getSimpleName() + " onStop");
            }

            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {
                Log.i(TAG, activity.getClass().getSimpleName() + " onDestroy");
            }
        });
    }

    private void initHelper() {
        WebSocketHelper.init(new WebSocketConfig());
    }

    private void initConfig() {
        WebSocketHelper.initConfig();
    }
}
