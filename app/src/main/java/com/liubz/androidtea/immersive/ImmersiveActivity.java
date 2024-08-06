package com.liubz.androidtea.immersive;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

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
        View decorView = getWindow().getDecorView();

//        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        // 全屏模式 & 应用主体内容占用系统状态栏
        ImmersiveUtils.setImmersiveMode(this, true);
//        getWindow().setNavigationBarColor(Color.TRANSPARENT);
    }

}
