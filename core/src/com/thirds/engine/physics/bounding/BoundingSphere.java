package com.thirds.engine.physics.bounding;

import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.CollisionData;

public class BoundingSphere extends BoundingObject {

	private Vector3 pos;
	private float radius;
	
	public BoundingSphere(Vector3 pos, float radius) {
		this.pos = pos;
		this.radius = radius;
	}
	
	@Override
	public CollisionData collideSphere(BoundingSphere other) {
		
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
		
		return new CollisionData(centreDistance < radiusDistance, intersectDistance);
	}
	
	public Vector3 getPos() {
		return pos;
	}
	
	public float getRadius() {
		return radius;
	}
}
