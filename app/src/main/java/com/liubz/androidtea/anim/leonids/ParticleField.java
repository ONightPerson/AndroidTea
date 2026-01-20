package com.liubz.androidtea.anim.leonids;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

class ParticleField extends View {

    private final Object mLock = new Object();

	private ArrayList<Particle> mParticles;

	public ParticleField(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public ParticleField(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public ParticleField(Context context) {
		super(context);
	}

	public void setParticles(ArrayList<Particle> particles) {
        synchronized (mLock) {
            mParticles = particles;
        }
	}
	
	@Override
	protected void onDraw(@NonNull Canvas canvas) {
		super.onDraw(canvas);
		// Draw all the particles
		synchronized (mLock) {
			for (int i = 0; i < mParticles.size(); i++) {
				mParticles.get(i).draw(canvas);
			}
		}
	}
}
