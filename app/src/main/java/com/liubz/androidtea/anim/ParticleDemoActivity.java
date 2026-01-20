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
 * @Desc: Leonids 粒子特效演示页面 (扩展多种场景)
 * @Author: liubaozhu
 */
public class ParticleDemoActivity extends AppCompatActivity {

    private ActivityParticleDemoBinding binding;
    private ParticleSystem mSnowSystem;

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

        // 2. 跟随手指效果 (在精确坐标发射)
        binding.btnFollow.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                new ParticleSystem(this, 100, R.drawable.ic_star, 800)
                        .setSpeedModuleAndAngleRange(0.05f, 0.15f, 0, 360)
                        .setScaleRange(0.5f, 1.2f)
                        .setFadeOut(300)
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

        // 4. 漫天飞雪 (持续发射场景)
        binding.btnSnow.setOnClickListener(v -> {
            if (mSnowSystem != null) {
                mSnowSystem.stopEmitting();
                mSnowSystem = null;
                binding.btnSnow.setText("漫天飞雪 (Snowing)");
            } else {
                mSnowSystem = new ParticleSystem(this, 100, R.drawable.ic_star, 10000);
                mSnowSystem.setSpeedModuleAndAngleRange(0.01f, 0.05f, 30, 150)
                        .setRotationSpeedRange(30, 90)
                        .setAcceleration(0.00005f, 90)
                        .emitWithGravity(binding.rootLayout, Gravity.TOP, 10);
                binding.btnSnow.setText("停止下雪");
            }
        });

        // 5. 星光闪烁 (从中心发射点)
        binding.btnStarEmit.setOnClickListener(v -> {
            new ParticleSystem(this, 100, R.drawable.ic_star, 2000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.25f, 0, 360)
                    .setRotationSpeed(144)
                    .setScaleRange(0.2f, 1.5f)
                    .setFadeOut(1000)
                    .emit(binding.rootLayout.getWidth() / 2, binding.rootLayout.getHeight() / 2, 30, 2000);
        });
    }

    @Override
    protected void onPause() {
        super.onAttachedToWindow();
        if (mSnowSystem != null) {
            mSnowSystem.cancel();
        }
    }
}
