package com.android.liubz.androidtea;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.Log;

import org.litepal.LitePal;

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

        LitePal.initialize(this);
        Log.i(TAG, "onCreate: pid: " + Process.myPid());


    }
}
