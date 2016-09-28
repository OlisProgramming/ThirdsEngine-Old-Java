package com.thirds.engine.physics;

public class CollisionData {

	private boolean doesIntersect;
	private float distance;
	
	public CollisionData(boolean doesIntersect, float distance) {
		this.doesIntersect = doesIntersect;
		this.distance = distance;
	}
	
	public boolean getDoesIntersect() {
		return doesIntersect;
	}

	public float getDistance() {
		return distance;
	}
}
