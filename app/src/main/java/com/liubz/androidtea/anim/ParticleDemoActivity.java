package com.liubz.androidtea.anim;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.liubz.androidtea.R;
import com.liubz.androidtea.anim.leonids.ParticleSystem;
import com.liubz.androidtea.databinding.ActivityParticleDemoBinding;

/**
 * @Desc: Leonids 粒子特效演示页面
 * @Author: liubaozhu
 */
public class ParticleDemoActivity extends AppCompatActivity {

    private ActivityParticleDemoBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityParticleDemoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Leonids 粒子特效");

        initListeners();
    }

    @SuppressLint("ClickableViewAccessibility")
    private void initListeners() {
        // 1. 屏幕撒花效果 (从顶部向下漂浮)
        binding.btnConfetti.setOnClickListener(v -> {
            // 参数说明：Activity, 最大粒子数, 图片资源, 生命周期(ms)
            new ParticleSystem(this, 80, R.drawable.ic_star, 5000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.2f, 0, 180) // 初始速度和向下发射的角度范围
                    .setRotationSpeedRange(90, 180) // 粒子旋转速度
                    .setAcceleration(0.00015f, 90) // 核心：设置向下的加速度(模拟重力)，角度90度表示垂直向下
                    .setFadeOut(1000) // 消失前淡出
                    // 从父布局顶部边缘发射，Gravity.TOP 确保从最上方开始
                    .emitWithGravity(binding.rootLayout, Gravity.TOP, 20, 3000); 
        });

        // 2. 跟随手指效果 (持续发射)
//        binding.btnFollow.setOnTouchListener((v, event) -> {
//            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
//                new ParticleSystem(this, 10, R.drawable.ic_star, 1000)
//                        .setSpeedModuleAndAngleRange(0.05f, 0.15f, 0, 360)
//                        .setScaleRange(0.5f, 1.2f)
//                        .setFadeOut(500)
//                        .oneShot((int) event.getRawX(), (int) event.getRawY(), 2);
//            }
//            return true;
//        });

        // 3. 一触即发 (按钮爆炸效果)
        binding.btnExplosion.setOnClickListener(v -> {
            new ParticleSystem(this, 50, R.drawable.ic_star, 1500)
                    .setSpeedModuleAndAngleRange(0.1f, 0.3f, 0, 360)
                    .setFadeOut(500)
                    .oneShot(v, 50);
        });
    }
}
