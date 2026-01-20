package com.liubz.androidtea.anim;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
            new ParticleSystem(this, 100, R.drawable.ic_star, 3000)
                    .setSpeedRange(0.1f, 0.25f)
                    .setRotationSpeedRange(90, 180)
                    .oneShot(binding.rootLayout, 100);
        });

        // 2. 跟随手指效果 (持续发射)
        binding.btnFollow.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                new ParticleSystem(this, 10, R.drawable.ic_star, 1000)
                        .setSpeedRange(0.1f, 0.2f)
                        .setScaleRange(0.5f, 1.5f)
                        .oneShot(binding.rootLayout, 100);
            }
            return true;
        });

        // 3. 一触即发 (按钮爆炸效果)
        binding.btnExplosion.setOnClickListener(v -> {
            new ParticleSystem(this, 50, R.drawable.ic_star, 1500)
                    .setSpeedRange(0.2f, 0.5f)
                    .oneShot(v, 50);
        });
    }
}
