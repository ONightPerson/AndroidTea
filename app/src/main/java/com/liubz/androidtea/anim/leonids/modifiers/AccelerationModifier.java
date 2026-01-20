package com.liubz.androidtea.anim.leonids.modifiers;

import com.liubz.androidtea.anim.leonids.Particle;

public class AccelerationModifier implements ParticleModifier {

    private final float mVelocityX;
    private final float mVelocityY;

    public AccelerationModifier(float velocity, float angle) {
        float velocityAngleInRads = (float) (angle * Math.PI / 180f);
        mVelocityX = (float) (velocity * Math.cos(velocityAngleInRads));
        mVelocityY = (float) (velocity * Math.sin(velocityAngleInRads));
    }

    @Override
    public void apply(Particle particle, long milliseconds) {
        particle.mCurrentX += mVelocityX * milliseconds * milliseconds;
        particle.mCurrentY += mVelocityY * milliseconds * milliseconds;
    }

}
