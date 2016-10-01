package com.thirds.engine.physics.collider;

import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.CollisionData;
import com.thirds.engine.physics.PhysicsObject;

/**
 * Any colliding object, for instance
 * a SphereCollider or a BoxCollider.
 * All Collider objects should
 * implement all methods outlined
 * below so that you can simply call
 * <code>a.collide(b)</code> and it
 * will compute collision data, no
 * questions asked.
 * 
 * If a new collider is added, it
 * shall implement all collision
 * detection functions with other
 * colliders rather than amending
 * already-existing classes.
 */
public abstract class Collider {
	
	protected PhysicsObject owner;
	protected Vector3 pos;
	
	public Collider(PhysicsObject owner) {
		this.owner = owner;
	}
	
	public CollisionData collide(Collider other) {
		
		if (other instanceof SphereCollider)
			return collideSphere((SphereCollider)other);
		else if (other instanceof AABBCollider)
			return collideAABB((AABBCollider)other);
		else if (other instanceof PlaneCollider)
			return collidePlane((PlaneCollider)other);
		
		return new CollisionData(false, 0.0f, this, other);
	}
	
	/**
	 * Compute <code>CollisionData</code> for this
	 * <code>Collider</code> colliding with
	 * a <code>SphereCollider</code>.
	 */
	public abstract CollisionData collideSphere(SphereCollider other);
	
	/**
	 * Compute <code>CollisionData</code> for this
	 * <code>Collider</code> colliding with
	 * an <code>AABBCollider</code>.
	 */
	public abstract CollisionData collideAABB(AABBCollider other);
	
	/**
	 * Compute <code>CollisionData</code> for this
	 * <code>Collider</code> colliding with
	 * an <code>PlaneCollider</code>.
	 */
	public abstract CollisionData collidePlane(PlaneCollider other);

	public PhysicsObject getOwner() {
		return owner;
	}

	public Vector3 getPos() {
		return pos;
	}

	public void setPos(Vector3 pos) {
		this.pos = pos;
	}
}
