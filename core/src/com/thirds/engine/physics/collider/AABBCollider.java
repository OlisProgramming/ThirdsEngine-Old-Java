package com.thirds.engine.physics.collider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.CollisionData;

public class AABBCollider extends Collider {

	/** Minimum extent of the AABB */
	private Vector3 min;
	/** Maximum extent of the AABB */
	private Vector3 max;

	/**
	 * @param a one extent of the AABB, not necessarily the minimum or maximum
	 * @param b the other extent of the AABB, not necessarily the minimum or maximum
	 */
	public AABBCollider(Vector3 a, Vector3 b) {
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
		Gdx.app.error("UNIMPLEMENTED METHOD", "Collide: AABB with Sphere");
		return null;
	}
	
	@Override
	public CollisionData collideAABB(AABBCollider other) {
		
		Vector3 d1 = other.min.sub(max);
		Vector3 d2 = min.sub(other.max);
		
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
		return new CollisionData(maxDistance < 0, maxDistance);
	}
	
	// TODO
	@Override
	public CollisionData collidePlane(PlaneCollider other) {
		return other.collideAABB(this);
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