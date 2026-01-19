package com.liubz.androidtea.view;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.databinding.ActivityScrollerTestBinding;

/**
 * @Desc: Scroller 弹性滑动测试页面
 * @Author: liubaozhu
 */
public class ScrollerTestActivity extends AppCompatActivity {

    private ActivityScrollerTestBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityScrollerTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Scroller 弹性滑动");

        initListeners();
    }

    private void initListeners() {
        // 触发弹性滑动：向右滑动 100 像素，向下滑动 100 像素
        binding.btnScrollTo.setOnClickListener(v -> {
            binding.smoothScrollView.smoothScrollTo(-100, -100);
        });

        // 重置位置：回到 (0, 0)
        binding.btnReset.setOnClickListener(v -> {
            binding.smoothScrollView.smoothScrollTo(0, 0);
        });
    }
}
