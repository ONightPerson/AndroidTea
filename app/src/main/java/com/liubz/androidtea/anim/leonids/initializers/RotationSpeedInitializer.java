package com.liubz.androidtea.anim.leonids.initializers;

import com.liubz.androidtea.anim.leonids.Particle;

import java.util.Random;

public class RotationSpeedInitializer implements ParticleInitializer {

    private final float mMinRotationSpeed;
    private final float mMaxRotationSpeed;

    public RotationSpeedInitializer(float minRotationSpeed, float maxRotationSpeed) {
        mMinRotationSpeed = minRotationSpeed;
        mMaxRotationSpeed = maxRotationSpeed;
    }

    @Override
    public void initParticle(Particle p, Random r) {
        p.mRotationSpeed = r.nextFloat() * (mMaxRotationSpeed - mMinRotationSpeed) + mMinRotationSpeed;
    }
}
