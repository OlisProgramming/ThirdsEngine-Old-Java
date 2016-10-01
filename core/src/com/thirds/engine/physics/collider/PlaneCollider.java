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

	@Override
	public CollisionData collideAABB(AABBCollider other) {
		
		float closestDistance = Integer.MAX_VALUE;
		for (int i=0; i<2; i++) {
			for (int j=0; j<2; j++) {
				for(int k=0; k<2; k++) {
					Vector3 point = new Vector3(
							i==0 ? other.getMin().x : other.getMax().x,
							j==0 ? other.getMin().y : other.getMax().y,
							k==0 ? other.getMin().z : other.getMax().z);
					// Point will loop through all eight points on the AABB
					float distanceToPoint = normal.dot(point) + distance;
					if (distanceToPoint < closestDistance)
						closestDistance = distanceToPoint;
				}
			}
		}
		
		return new CollisionData(closestDistance < 0, closestDistance, this, other);
	}

	// Planes do not need to collide with planes, they are infinitely large
	@Override
	public CollisionData collidePlane(PlaneCollider other) {
		return new CollisionData(false, 0f, null, null);
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
