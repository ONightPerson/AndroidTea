package com.android.liubz.androidtea.utils;

import android.content.Context;

import com.android.liubz.androidtea.TeaApplication;

public class ApplicationUtils {

    private static TeaApplication sApp;

    public static void initApplication(TeaApplication app) {
        sApp = app;
    }

    public static Context getAppContext() {
        return sApp;
    }

}
