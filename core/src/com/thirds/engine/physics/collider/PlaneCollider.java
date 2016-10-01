package com.thirds.engine.physics.collider;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.CollisionData;
import com.thirds.engine.physics.PhysicsObject;

public class PlaneCollider extends Collider {

	private Vector3 normal;
	private float distance;
	
	public PlaneCollider(PhysicsObject owner, Vector3 normal, float distance) {
		super(owner);
		setNormal(normal);
		setDistance(distance);
	}

	public PlaneCollider nor() {
		float len = normal.len();
		return new PlaneCollider(owner, normal.scl(1f / len), distance * len);
	}
	
	@Override
	public CollisionData collideSphere(SphereCollider other) {
		
		float distanceFromSphereCentre = Math.abs(normal.dot(other.getPos()) + distance);
		float distanceFromSphere = distanceFromSphereCentre - other.getRadius();
		
		return new CollisionData(distanceFromSphere < 0, distanceFromSphere, this, other);
	}

	// TODO
	@Override
	public CollisionData collideAABB(AABBCollider other) {
		Gdx.app.error("UNIMPLEMENTED METHOD", "Collide: Plane with AABB");
		return null;
	}

	// TODO
	@Override
	public CollisionData collidePlane(PlaneCollider other) {
		Gdx.app.error("UNIMPLEMENTED METHOD", "Collide: Plane with Plane");
		return null;
	}

	public Vector3 getNormal() {
		return normal;
	}

	public void setNormal(Vector3 normal) {
		this.normal = normal;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}
}
