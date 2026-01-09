package com.liubz.androidtea.stack.launchmode.singletask;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivitySingleTaskBinding;
import com.liubz.androidtea.stack.launchmode.OtherActivity;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 7:11 PM
 */
public class SingleTaskActivity extends BaseActivity {
    private ActivitySingleTaskBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingleTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("SingleTaskActivity");
        
        initListeners();
    }

    private void initListeners() {
        binding.singleTaskLaunchSelfBtn.setOnClickListener(v -> launchSingleTaskActivity());
        binding.singleTaskLaunchOtherBtn.setOnClickListener(v -> launchOtherActivity());
    }

    private void launchSingleTaskActivity() {
        startActivity(new Intent(this, SingleTaskActivity.class));
    }

    private void launchOtherActivity() {
        startActivity(new Intent(this, OtherActivity.class));
    }
}
