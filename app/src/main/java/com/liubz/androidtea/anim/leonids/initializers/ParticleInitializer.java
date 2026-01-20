package com.liubz.androidtea.anim.leonids.initializers;

import com.liubz.androidtea.anim.leonids.Particle;

import java.util.Random;

public interface ParticleInitializer {

	void initParticle(Particle p, Random r);

}
