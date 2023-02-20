package com.liubz.androidtea.stack.launchmode;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/19 6:22 PM
 */
@SuppressWarnings("LongLogTag")
public class TransparentActivity extends BaseActivity {
    private static final String TAG = "TransparentActivity" + LAUNCH_MODE_TAG_SUFFIX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("TransparentActivity");
        Log.i(TAG, "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy");
    }
}
