package com.liubz.androidtea.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityWaveDemoBinding;

/**
 * @Desc: 自定义波纹滚动效果演示页面
 * @Author: liubaozhu
 */
public class WaveDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityWaveDemoBinding binding = ActivityWaveDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("波纹滚动效果");
    }
}
