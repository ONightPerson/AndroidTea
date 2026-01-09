package com.liubz.androidtea.stack.launchmode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityOtherBinding;
import com.liubz.androidtea.stack.launchmode.singleinstance.SingleInstanceActivity;
import com.liubz.androidtea.stack.launchmode.singletask.SingleTaskActivity;
import com.liubz.androidtea.stack.launchmode.singletop.SingleTopActivity;

import static com.liubz.androidtea.stack.launchmode.LaunchModeConst.LAUNCH_MODE_TAG_SUFFIX;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 5:14 PM
 */
@SuppressLint("LongLogTag")
public class OtherActivity extends AppCompatActivity {
    private static final String TAG = "OtherActivity" + LAUNCH_MODE_TAG_SUFFIX;
    private ActivityOtherBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtherBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("OtherActivity");

        initListeners();
    }

    private void initListeners() {
        binding.otherSingleTopBtn.setOnClickListener(v -> startActivity(new Intent(this, SingleTopActivity.class)));
        binding.otherSingleTaskBtn.setOnClickListener(v -> startActivity(new Intent(this, SingleTaskActivity.class)));
        binding.otherSingleInstanceBtn.setOnClickListener(v -> startActivity(new Intent(this, SingleInstanceActivity.class)));
    }
}
