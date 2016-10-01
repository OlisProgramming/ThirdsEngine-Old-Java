package com.thirds.engine.physics;

public class PhysicsObjectFactory {

	public static enum PhysicsObjectType {
		SPHERE,
		AABB,
		PLANE
	}
	
	public static PhysicsObject createObject(PhysicsObjectType objectType) {
		return null;
	}
}
