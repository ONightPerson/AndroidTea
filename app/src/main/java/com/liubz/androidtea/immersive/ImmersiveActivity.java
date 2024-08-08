package com.liubz.androidtea.immersive;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.liubz.androidtea.R;
import com.liubz.androidtea.base.BaseActivity;

/**
 * @Desc:
 * @Author: liubaozhu
 * @Date: 2023/2/21 8:10 PM
 */
public class ImmersiveActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
        // 全屏模式 & 应用主体内容占用系统状态栏
        ImmersiveUtils.setImmersiveMode(this, false);
    }
}
