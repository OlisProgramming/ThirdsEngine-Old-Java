package com.thirds.engine.physics.collider;

import com.thirds.engine.physics.CollisionData;

/**
 * Any colliding object, for instance
 * a SphereCollider or a BoxCollider.
 * All Collider objects should
 * implement all methods outlined
 * below so that you can simply call
 * <code>a.collide(b)</code> and it
 * will compute collision data, no
 * questions asked.
 */
public abstract class Collider {
	
	public CollisionData collide(Collider other) {
		
		if (other instanceof SphereCollider)
			return collideSphere((SphereCollider)other);
		
		return new CollisionData(false, 0.0f);
	}
	
	/**
	 * Compute <code>CollisionData</code> for this
	 * <code>Collider</code> colliding with
	 * a <code>SphereCollider</code>.
	 */
	public abstract CollisionData collideSphere(SphereCollider other);
}
