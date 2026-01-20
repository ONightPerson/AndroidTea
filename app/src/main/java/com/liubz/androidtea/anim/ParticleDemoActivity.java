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

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc: Leonids 粒子特效演示页面 (深度优化雪花效果)
 * @Author: liubaozhu
 */
public class ParticleDemoActivity extends AppCompatActivity {

    private ActivityParticleDemoBinding binding;
    private List<ParticleSystem> mSnowSystems = new ArrayList<>();
    private boolean mIsSnowing = false;

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
        // 1. 屏幕撒花效果
        binding.btnConfetti.setOnClickListener(v -> {
            new ParticleSystem(this, 80, R.drawable.ic_star, 5000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.2f, 0, 180)
                    .setRotationSpeedRange(90, 180)
                    .setAcceleration(0.00015f, 90)
                    .setFadeOut(1000)
                    .emitWithGravity(binding.rootLayout, Gravity.TOP, 20, 3000); 
        });

        // 2. 跟随手指效果
        binding.btnFollow.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                new ParticleSystem(this, 100, R.drawable.ic_snowflake, 800)
                        .setSpeedModuleAndAngleRange(0.05f, 0.15f, 0, 360)
                        .setScaleRange(0.3f, 0.8f)
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

        // 4. 漫天飞雪 (重新实现：双层叠加模拟景深)
        binding.btnSnow.setOnClickListener(v -> {
            if (mIsSnowing) {
                stopSnowing();
            } else {
                startSnowing();
            }
        });

        // 5. 星光闪烁
        binding.btnStarEmit.setOnClickListener(v -> {
            new ParticleSystem(this, 100, R.drawable.ic_star, 2000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.25f, 0, 360)
                    .setRotationSpeed(144)
                    .setScaleRange(0.2f, 1.5f)
                    .setFadeOut(1000)
                    .emit(binding.rootLayout.getWidth() / 2, binding.rootLayout.getHeight() / 2, 30, 2000);
        });
    }

    private void startSnowing() {
        mIsSnowing = true;
        binding.btnSnow.setText("停止下雪");

        // 层级 1：远景 (更小、更慢、更透)
        ParticleSystem layer1 = new ParticleSystem(this, 60, R.drawable.ic_snowflake, 12000);
        layer1.setSpeedByComponentsRange(-0.02f, 0.02f, 0.02f, 0.05f) // 轻微横向风
                .setScaleRange(0.2f, 0.4f)
                .setAcceleration(0.00001f, 90)
                .emitWithGravity(binding.rootLayout, Gravity.TOP, 8);
        
        // 层级 2：中景 (标准大小)
        ParticleSystem layer2 = new ParticleSystem(this, 40, R.drawable.ic_snowflake, 8000);
        layer2.setSpeedByComponentsRange(-0.03f, 0.03f, 0.05f, 0.1f)
                .setScaleRange(0.5f, 0.8f)
                .setAcceleration(0.00003f, 90)
                .emitWithGravity(binding.rootLayout, Gravity.TOP, 12);

        mSnowSystems.add(layer1);
        mSnowSystems.add(layer2);
    }

    private void stopSnowing() {
        mIsSnowing = false;
        binding.btnSnow.setText("漫天飞雪 (Snowing)");
        for (ParticleSystem ps : mSnowSystems) {
            ps.stopEmitting();
        }
        mSnowSystems.clear();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopSnowing();
    }
}
