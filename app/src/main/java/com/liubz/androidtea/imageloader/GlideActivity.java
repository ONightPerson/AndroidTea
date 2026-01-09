package com.liubz.androidtea.imageloader;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.liubz.androidtea.base.BaseActivity;
import com.liubz.androidtea.databinding.ActivityGlideBinding;


/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/5/18 3:54 PM
 */
public class GlideActivity extends BaseActivity {
    private ActivityGlideBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGlideBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initViews();
    }

    private void initViews() {
        Glide.with(this)
          .load("https://picx.zhimg.com/v2-3b4fc7e3a1195a081d0259246c38debc_1440w.jpg?source=172ae18b")
          .centerCrop()
          .into(binding.imageView);
    }
}
