package com.liubz.androidtea;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.liubz.androidtea.utils.ApplicationUtils;
import com.liubz.androidtea.utils.CrashHandler;

import dagger.hilt.android.HiltAndroidApp;

/**
 * @Desc: 应用程序入口，标注 @HiltAndroidApp 触发 Hilt 的代码生成
 */
@HiltAndroidApp
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

        CrashHandler.getInstance().init(this);

        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
                Log.i(TAG, activity.getClass().getSimpleName() + " onCreate");
            }

            @Override
            public void onActivityStarted(@NonNull Activity activity) {}
            @Override
            public void onActivityResumed(@NonNull Activity activity) {}
            @Override
            public void onActivityPaused(@NonNull Activity activity) {}
            @Override
            public void onActivityStopped(@NonNull Activity activity) {}
            @Override
            public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {}
            @Override
            public void onActivityDestroyed(@NonNull Activity activity) {}
        });
    }
}
