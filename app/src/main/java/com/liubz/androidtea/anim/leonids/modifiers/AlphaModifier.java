package com.liubz.androidtea.anim.leonids.modifiers;

import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

import com.liubz.androidtea.anim.leonids.Particle;

public class AlphaModifier implements ParticleModifier {

    private final int mInitialValue;
    private final int mFinalValue;
    private final long mStartTime;
    private final long mEndTime;
    private final float mDuration;
    private final float mValueIncrement;
    private final Interpolator mInterpolator;

    public AlphaModifier(int initialValue, int finalValue, long startMilis, long endMilis, Interpolator interpolator) {
        mInitialValue = initialValue;
        mFinalValue = finalValue;
        mStartTime = startMilis;
        mEndTime = endMilis;
        mDuration = mEndTime - mStartTime;
        mValueIncrement = mFinalValue - mInitialValue;
        mInterpolator = interpolator;
    }

    public AlphaModifier(int initialValue, int finalValue, long startMilis, long endMilis) {
        this(initialValue, finalValue, startMilis, endMilis, new LinearInterpolator());
    }

    @Override
    public void apply(Particle particle, long milliseconds) {
        if (milliseconds < mStartTime) {
            particle.mAlpha = mInitialValue;
        } else if (milliseconds > mEndTime) {
            particle.mAlpha = mFinalValue;
        } else {
            float interpolatorValue = mInterpolator.getInterpolation((milliseconds - mStartTime) * 1f / mDuration);
            particle.mAlpha = (int) (mInitialValue + mValueIncrement * interpolatorValue);
        }
    }
}
