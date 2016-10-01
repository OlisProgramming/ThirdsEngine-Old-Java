package com.thirds.engine.physics.collider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.CollisionData;
import com.thirds.engine.physics.PhysicsObject;

public class AABBCollider extends Collider {

	/** Minimum extent of the AABB */
	private Vector3 min;
	/** Maximum extent of the AABB */
	private Vector3 max;

	/**
	 * Alternative constructor for AABBCollider.
	 * @param x the width of the AABB
	 * @param y the height of the AABB
	 * @param z the depth of the AABB
	 */
	public AABBCollider(PhysicsObject owner, Vector3 pos, float x, float y, float z) {
		super(owner);
		super.setPos(pos);
		setMin(pos.cpy().sub(x/2f, y/2f, z/2f));
		setMax(pos.cpy().add(x/2f, y/2f, z/2f));
	}
	
	/**
	 * @param a one extent of the AABB, not necessarily the minimum or maximum
	 * @param b the other extent of the AABB, not necessarily the minimum or maximum
	 */
	public AABBCollider(PhysicsObject owner, Vector3 a, Vector3 b) {
		super(owner);
		
		/*
		 * Select minimum and maximum values of
		 * the x, y and z coordinates
		 */
		min = new Vector3(
				(a.x>b.x) ? b.x : a.x,
				(a.y>b.y) ? b.y : a.y,
				(a.z>b.z) ? b.z : a.z
			);
		max = new Vector3(
				(a.x>b.x) ? a.x : b.x,
				(a.y>b.y) ? a.y : b.y,
				(a.z>b.z) ? a.z : b.z
			);
	}
	
	// TODO
	@Override
	public CollisionData collideSphere(SphereCollider other) {
		
		// Get closest point on AABB
		Vector3 point;
		point = new Vector3();
		
		point.x = (other.pos.x < min.x) ? min.x : (other.pos.x > max.x) ? max.x : other.pos.x;
		point.y = (other.pos.y < min.y) ? min.y : (other.pos.y > max.y) ? max.y : other.pos.y;
		point.z = (other.pos.z < min.z) ? min.z : (other.pos.z > max.z) ? max.z : other.pos.z;
		
		// Get distance between point and centre of sphere
		float dist = point.sub(other.pos).len();
		
		// Get distance between point and edge of sphere
		float distMinusRad = dist - other.getRadius();
		
		Gdx.app.log("", Float.toString(distMinusRad));
		
		return new CollisionData(distMinusRad < 0, distMinusRad, this, other);
	}
	
	@Override
	public CollisionData collideAABB(AABBCollider other) {
		
		Vector3 d1 = other.min.cpy().sub(max);
		Vector3 d2 = min.cpy().sub(other.max);
		
		// Find max distance
		Vector3 d = new Vector3(
				(d1.x>d2.x) ? d1.x : d2.x,
				(d1.y>d2.y) ? d1.y : d2.y,
				(d1.z>d2.z) ? d1.z : d2.z);
		
		// Find maximum component of 'd'
		float maxDistance =
				(d.x > d.y && d.x > d.z) ? d.x :
				((d.y > d.x && d.y > d.z) ? d.y : d.z);
		
		/*
		 * Does NOT return the physical distance, it does NOT
		 * return an actual vector length.
		 */
		return new CollisionData(maxDistance < 0, maxDistance, this, other);
	}
	
	// TODO
	@Override
	public CollisionData collidePlane(PlaneCollider other) {
		return other.collideAABB(this);
	}
	
	@Override
	public void setPos(Vector3 pos) {
		super.setPos(pos);
		
		// The first time setters have actually been useful for me
		
		Vector3 halfDimensions = getMax().cpy().sub(getMin()).scl(0.5f);
		
		setMin(pos.cpy().sub(halfDimensions));
		setMax(pos.cpy().add(halfDimensions));
	}
	
	public Vector3 getMin() {
		return min;
	}

	public void setMin(Vector3 min) {
		this.min = min;
	}

	public Vector3 getMax() {
		return max;
	}

	public void setMax(Vector3 max) {
		this.max = max;
	}
}
