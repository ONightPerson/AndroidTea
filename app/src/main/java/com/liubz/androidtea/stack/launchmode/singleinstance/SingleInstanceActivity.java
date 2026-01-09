package com.liubz.androidtea.stack.launchmode.singleinstance;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivitySingleInstanceBinding;
import com.liubz.androidtea.stack.launchmode.OtherActivity;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/17 7:31 PM
 */
public class SingleInstanceActivity extends BaseActivity {
    private ActivitySingleInstanceBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySingleInstanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("SingleInstanceActivity");
        
        binding.singleInstanceLaunchOtherBtn.setOnClickListener(v -> launchOtherActivity());
    }

    private void launchOtherActivity() {
        startActivity(new Intent(this, OtherActivity.class));
    }
}
