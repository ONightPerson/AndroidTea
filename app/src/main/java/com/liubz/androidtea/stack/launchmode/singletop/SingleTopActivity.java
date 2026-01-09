package com.liubz.androidtea.stack.launchmode.singletop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivitySingleTopBinding;
import com.liubz.androidtea.stack.launchmode.OtherActivity;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 6:49 PM
 */
public class SingleTopActivity extends BaseActivity {
    private static final String TAG = "SingleTopActivity" + LAUNCH_MODE_TAG_SUFFIX;
    private ActivitySingleTopBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingleTopBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("SingleTopActivity");
        
        initListeners();
    }

    private void initListeners() {
        binding.launchModeSingleTopBtn.setOnClickListener(v -> launchSingleTopActivity());
        binding.launchModeOtherBtn.setOnClickListener(v -> launchOtherActivity());
    }

    private void launchSingleTopActivity() {
        startActivity(new Intent(this, SingleTopActivity.class));
    }

    private void launchOtherActivity() {
        startActivity(new Intent(this, OtherActivity.class));
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.i(TAG, "onNewIntent");
    }
}
