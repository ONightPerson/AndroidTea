package com.liubz.androidtea.anim.leonids.initializers;

import com.liubz.androidtea.anim.leonids.Particle;

import java.util.Random;

/**
 * @Desc: 粒子加速度初始化器
 * 负责在粒子创建时为其设置初始加速度矢量。
 * 通过指定加速度的大小范围和角度范围，可以模拟重力、恒定风力等物理效果。
 * @Author: liubaozhu
 */
public class AccelerationInitializer implements ParticleInitializer {

    private final float mMinValue;
    private final float mMaxValue;
    private final int mMinAngle;
    private final int mMaxAngle;

    public AccelerationInitializer(float minAcceleration, float maxAcceleration, int minAngle, int maxAngle) {
        mMinValue = minAcceleration;
        mMaxValue = maxAcceleration;
        mMinAngle = minAngle;
        mMaxAngle = maxAngle;
    }

    @Override
    public void initParticle(Particle p, Random r) {
        float angle = mMinAngle;
        if (mMaxAngle != mMinAngle) {
            angle = r.nextInt(mMaxAngle - mMinAngle) + mMinAngle;
        }
        float angleInRads = (float) (angle * Math.PI / 180f);
        float value = r.nextFloat() * (mMaxValue - mMinValue) + mMinValue;
        p.mAccelerationX = (float) (value * Math.cos(angleInRads));
        p.mAccelerationY = (float) (value * Math.sin(angleInRads));
    }
}
