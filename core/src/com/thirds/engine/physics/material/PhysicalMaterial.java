package com.thirds.engine.physics.material;

public class PhysicalMaterial {

	/**
	 * The 'bounciness' of the object. In a
	 * collision, the restitution of one
	 * object is multiplied by the other's
	 * restitution to give the total amount
	 * of bounce on the collision.
	 * <code>1.0f</code> on both surfaces
	 * would warrant a collision where no
	 * friction or air resistance effected
	 * it, and <code>0.0f</code> on either
	 * surface would result in a collision
	 * with no bounce.
	 */
	private float restitution;
	
	public PhysicalMaterial() {
		restitution = 0.8f;
	}

	public float getRestitution() {
		return restitution;
	}

	/** Returns this for chaining. */
	public PhysicalMaterial setRestitution(float restitution) {
		this.restitution = restitution;
		return this;
	}
}
