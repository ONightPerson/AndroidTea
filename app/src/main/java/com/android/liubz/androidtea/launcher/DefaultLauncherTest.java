package com.android.liubz.androidtea.launcher;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * Created by liubaozhu on 2020/7/1
 */
public class DefaultLauncherTest extends Activity {
    private static final String TAG = "DefaultLauncherTest";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        ResolveInfo resolveInfo = getPackageManager().resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY);
        String currentHomePackage = resolveInfo.activityInfo.packageName;
        Log.i(TAG, "onCreate: currentHomePackage " + currentHomePackage);
    }
}
