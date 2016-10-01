package com.thirds.engine.physics;

import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.collider.AABBCollider;
import com.thirds.engine.physics.collider.PlaneCollider;
import com.thirds.engine.physics.collider.SphereCollider;

public class PhysicsObjectFactory {
	
	public static PhysicsObject createSphere(Vector3 pos, float radius) {
		PhysicsObject obj = new PhysicsObject(pos);
		obj.setCollider(new SphereCollider(obj, radius));
		return obj;
	}
	
	public static PhysicsObject createAABB(Vector3 pos, float x, float y, float z) {
		PhysicsObject obj = new PhysicsObject(pos);
		obj.setCollider(new AABBCollider(obj, pos, x, y, z));
		return obj;
	}
	
	public static PhysicsObject createAABB(Vector3 a, Vector3 b) {
		// Calculate mean of a and b
		Vector3 pos = a.cpy().scl(0.5f).add(b.cpy().scl(0.5f));
		PhysicsObject obj = new PhysicsObject(pos);
		
		obj.setCollider(new AABBCollider(obj, a, b));
		return obj;
	}
	
	public static PhysicsObject createPlane(Vector3 normal, float distance) {
		PhysicsObject obj = new PhysicsObject();
		obj.setCollider(new PlaneCollider(obj, normal, distance));
		return obj;
	}
}
