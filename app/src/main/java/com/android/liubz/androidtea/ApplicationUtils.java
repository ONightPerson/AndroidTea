package com.android.liubz.androidtea;

import android.content.Context;

public class ApplicationUtils {

    private static TeaApplication sApp;

    public static void initApplication(TeaApplication app) {
        sApp = app;
    }

    public static Context getAppContext() {
        return sApp;
    }

}
