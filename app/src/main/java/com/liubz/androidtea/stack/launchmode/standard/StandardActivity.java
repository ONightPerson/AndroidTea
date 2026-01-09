package com.liubz.androidtea.stack.launchmode.standard;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivityStandardBinding;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 5:25 PM
 */
@SuppressLint("LongLogTag")
public class StandardActivity extends BaseActivity {
    private static final String TAG = "StandardActivity" + LAUNCH_MODE_TAG_SUFFIX;
    private ActivityStandardBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStandardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("StandardActivity");

        binding.launchModeStandardBtn.setOnClickListener(v -> launchStandardActivity());
    }

    private void launchStandardActivity() {
        startActivity(new Intent(this, StandardActivity.class));
    }
}
