package com.android.liubz.androidtea.modules.accessibility;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import org.jetbrains.annotations.Nullable;

/**
 * Created by liubz on 18-4-18.
 */

@SuppressLint("LongLogTag")
public class AccessibilityJumpActivity extends Activity {
    private static final String TAG = AccessibilityConstant.TAG + "AccessibilityJumpActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        onNewIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Intent target = intent.getParcelableExtra(AccessibilityConstant.EXTRA_TARGET_INTENT);
        Log.i(TAG, "onNewIntent: target: " + target);
        if (target != null) {
            startActivity(target);
        } else {
            finish();
        }
    }

    public static void show(Context context, Intent target) {
        Log.i(TAG, "show");
        Intent intent = new Intent(context, AccessibilityJumpActivity.class);
        intent.putExtra(AccessibilityConstant.EXTRA_TARGET_INTENT, target);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public static void dismiss(Context context) {
        Log.i(TAG, "dismiss");
        Intent intent = new Intent(context, AccessibilityJumpActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
