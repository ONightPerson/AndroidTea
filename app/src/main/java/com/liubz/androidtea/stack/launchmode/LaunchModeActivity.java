package com.liubz.androidtea.stack.launchmode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityLaunchModeBinding;
import com.liubz.androidtea.stack.launchmode.singleinstance.SingleInstanceActivity;
import com.liubz.androidtea.stack.launchmode.singletask.SingleTaskActivity;
import com.liubz.androidtea.stack.launchmode.singletop.SingleTopActivity;
import com.liubz.androidtea.stack.launchmode.standard.StandardActivity;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc: 验证launch mode
 * @Author: liubaozhu
 * @Date: 2023/2/17 4:51 PM
 */
@SuppressLint("LongLogTag")
public class LaunchModeActivity extends AppCompatActivity {
    private static final String TAG = "LaunchModeActivity" + LAUNCH_MODE_TAG_SUFFIX;
    private ActivityLaunchModeBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        binding = ActivityLaunchModeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("LaunchModeActivity");
        
        initListeners();
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

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState");
    }

    private void initListeners() {
        binding.launchModeStandardBtn.setOnClickListener(v -> launchStandardMode());
        binding.launchModeSingleTopBtn.setOnClickListener(v -> launchSingleTopMode());
        binding.launchModeSingleTaskBtn.setOnClickListener(v -> launchSingleTaskMode());
        binding.launchModeSingleInstanceBtn.setOnClickListener(v -> launchSingleInstance());
    }

    private void launchStandardMode() {
        startActivity(new Intent(this, StandardActivity.class));
    }

    private void launchSingleTopMode() {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    private void launchSingleTaskMode() {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    private void launchSingleInstance() {
        startActivity(new Intent(this, SingleInstanceActivity.class));
    }
}
