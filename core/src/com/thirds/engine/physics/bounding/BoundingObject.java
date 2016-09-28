package com.thirds.engine.physics.bounding;

import com.thirds.engine.physics.CollisionData;

/**
 * Any bounding object, for instance
 * a BoundingSphere or a BoundingBox.
 * All Bounding objects should
 * implement all methods outlined
 * below so that you can simply call
 * <code>a.collide(b)</code> and it
 * will compute collision data, no
 * questions asked.
 */
public abstract class BoundingObject {
	
	public CollisionData collide(BoundingObject other) {
		
		if (other instanceof BoundingSphere)
			return collideSphere((BoundingSphere)other);
		
		return new CollisionData(false, 0.0f);
	}
	
	/**
	 * Compute <code>CollisionData</code> for this
	 * <code>BoundingObject</code> colliding with
	 * a <code>BoundingSphere</code>.
	 */
	public abstract CollisionData collideSphere(BoundingSphere other);
}
