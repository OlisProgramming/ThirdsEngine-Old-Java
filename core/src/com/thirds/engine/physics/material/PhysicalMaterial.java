package com.thirds.engine.physics.material;

public class PhysicalMaterial {

	/**
	 * How much friction/air resistance is applied to the object every tick.
	 */
	private float friction;
	
	public PhysicalMaterial() {
		friction = 0.01f;
	}

	public float getFriction() {
		return friction;
	}

	/** Returns this for chaining. */
	public PhysicalMaterial setFriction(float friction) {
		this.friction = friction;
		return this;
	}
}
