package com.thirds.engine.physics.collider;

import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.CollisionData;
import com.thirds.engine.physics.PhysicsObject;

public class SphereCollider extends Collider {

	private Vector3 pos;
	private float radius;
	
	public SphereCollider(PhysicsObject owner, Vector3 pos, float radius) {
		super(owner);
		this.pos = pos;
		this.radius = radius;
	}
	
	public SphereCollider(PhysicsObject owner, float radius) {
		this(owner, new Vector3(), radius);
	}

	@Override
	public CollisionData collideSphere(SphereCollider other) {
		
		/*
		 * The distance between the edge of this sphere
		 * to its centre, added to the distance of the
		 * nearest edge of the other sphere to its
		 * centre.
		 * This gives us the total distance to subtract
		 * from the distance between the spheres' centres
		 * in order to find the distance between the
		 * spheres.
		 */
		float radiusDistance = radius + other.radius;
		
		/*
		 * The distance between the centres of the spheres.
		 */
		float centreDistance = (other.pos.sub(pos)).len();
		
		/*
		 * The distance between the closest edges of the
		 * spheres. A negative number means an intersection
		 * has taken place.
		 */
		float intersectDistance = centreDistance - radiusDistance;
		
		return new CollisionData(centreDistance < radiusDistance, intersectDistance, this, other);
	}
	
	@Override
	public CollisionData collideAABB(AABBCollider other) {
		return other.collideSphere(this);
	}
	
	@Override
	public CollisionData collidePlane(PlaneCollider other) {
		return other.collideSphere(this);
	}
	
	public Vector3 getPos() {
		return pos;
	}
	
	public void setPos(Vector3 pos) {
		this.pos = pos;
	}
	
	public float getRadius() {
		return radius;
	}
	
	public void setRadius(float radius) {
		this.radius = radius;
	}
}
