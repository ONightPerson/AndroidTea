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
 * @Desc: Leonids 粒子特效演示页面 (集成仙女散花效果)
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
        // 1. 屏幕撒花效果 (星星)
        binding.btnConfetti.setOnClickListener(v -> {
            new ParticleSystem(this, 80, R.drawable.ic_flower, 5000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.2f, 0, 180)
                    .setRotationSpeedRange(90, 180)
                    .setAcceleration(0.00015f, 90)
                    .setFadeOut(1000)
                    .emitWithGravity(binding.rootLayout, Gravity.TOP, 20, 3000); 
        });

        // 2. 跟随手指效果 (小花朵)
        binding.btnFollow.setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE) {
                new ParticleSystem(this, 50, R.drawable.ic_star, 800)
                        .setSpeedModuleAndAngleRange(0.05f, 0.15f, 0, 360)
                        .setScaleRange(0.3f, 0.6f)
                        .setFadeOut(300)
                        .emit((int) event.getRawX(), (int) event.getRawY(), 40, 50);
            }
            return true;
        });

        // 3. 一触即发 (爆炸效果)
        binding.btnExplosion.setOnClickListener(v -> {
            new ParticleSystem(this, 50, R.drawable.ic_star, 1500)
                    .setSpeedModuleAndAngleRange(0.1f, 0.3f, 0, 360)
                    .setFadeOut(500)
                    .oneShot(v, 50);
        });

        // 4. 漫天飞雪 (精细雪花)
        binding.btnSnow.setOnClickListener(v -> {
            if (mIsSnowing) {
                stopSnowing();
            } else {
                startSnowing();
            }
        });

        // 5. 星光闪烁 (中心放射)
        binding.btnStarEmit.setOnClickListener(v -> {
            new ParticleSystem(this, 100, R.drawable.ic_star, 2000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.25f, 0, 360)
                    .setRotationSpeed(144)
                    .setScaleRange(0.2f, 1.5f)
                    .setFadeOut(1000)
                    .emit(binding.rootLayout.getWidth() / 2, binding.rootLayout.getHeight() / 2, 30, 2000);
        });

        // 6. 仙女散花效果：从屏幕顶部中心放射状喷发大花朵
        binding.btnFlowerScatter.setOnClickListener(v -> {
            new ParticleSystem(this, 100, R.drawable.ic_flower, 5000)
                    .setSpeedModuleAndAngleRange(0.1f, 0.4f, 0, 360) // 360度喷射
                    .setRotationSpeedRange(90, 270)                 // 高速随机旋转
                    .setAcceleration(0.00012f, 90)                  // 模拟重力下落
                    .setScaleRange(0.6f, 1.2f)                      // 花朵大小不一
                    .setFadeOut(1500)                               // 消失前缓慢淡出
                    .emit(binding.rootLayout.getWidth() / 2, 50, 40, 3000); // 坐标发射
        });
    }

    private void startSnowing() {
        mIsSnowing = true;
        binding.btnSnow.setText("停止下雪");

        // 使用 899 号高精度雪花进行渲染
        ParticleSystem layer1 = new ParticleSystem(this, 60, R.drawable.ic_snowflake899, 12000);
        layer1.setSpeedByComponentsRange(-0.02f, 0.02f, 0.02f, 0.05f)
                .setScaleRange(0.2f, 0.4f)
                .setAcceleration(0.00001f, 90)
                .emitWithGravity(binding.rootLayout, Gravity.TOP, 8);
        
        ParticleSystem layer2 = new ParticleSystem(this, 40, R.drawable.ic_snowflake899, 8000);
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
