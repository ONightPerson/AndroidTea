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
            new ParticleSystem(this, 80, R.drawable.ic_star, 5000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.2f, 0, 180)
                    .setRotationSpeedRange(90, 180)
                    .setAcceleration(0.00015f, 90)
                    .setFadeOut(1000)
                    .emitWithGravity(binding.rootLayout, Gravity.TOP, 20, 3000); 
        });

        // 2. 跟随手指效果 (修复版：使用 emit 在精确坐标发射)
        binding.btnFollow.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                new ParticleSystem(this, 100, R.drawable.ic_star, 800)
                        .setSpeedModuleAndAngleRange(0.05f, 0.15f, 0, 360)
                        .setScaleRange(0.5f, 1.2f)
                        .setFadeOut(300)
                        // 修正点：使用 emit 方法。在坐标 (x, y) 处，每秒发射 50 个粒子，发射持续 50 毫秒。
                        .emit((int) event.getRawX(), (int) event.getRawY(), 50, 50);
            }
            return true;
        });

        // 3. 一触即发 (按钮爆炸效果)
        binding.btnExplosion.setOnClickListener(v -> {
            new ParticleSystem(this, 50, R.drawable.ic_star, 1500)
                    .setSpeedModuleAndAngleRange(0.1f, 0.3f, 0, 360)
                    .setFadeOut(500)
                    .oneShot(v, 50);
        });
    }
}
