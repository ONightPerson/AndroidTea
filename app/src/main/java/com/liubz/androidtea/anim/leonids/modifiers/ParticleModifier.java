package com.liubz.androidtea.anim.leonids.modifiers;

import com.liubz.androidtea.anim.leonids.Particle;

public interface ParticleModifier {

	/**
	 * modifies the specific value of a particle given the current miliseconds
	 * @param particle
	 * @param miliseconds
	 */
	void apply(Particle particle, long miliseconds);

}
