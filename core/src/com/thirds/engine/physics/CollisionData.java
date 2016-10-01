package com.thirds.engine.physics;

import com.thirds.engine.physics.collider.Collider;

public class CollisionData {

	private boolean doesIntersect;
	private float distance;
	
	private Collider a;
	private Collider b;
	
	public CollisionData(boolean doesIntersect, float distance, Collider a, Collider b) {
		this.doesIntersect = doesIntersect;
		this.distance = distance;
		setA(a);
		setB(b);
	}
	
	public boolean getDoesIntersect() {
		return doesIntersect;
	}

	public float getDistance() {
		return distance;
	}

	public Collider getA() {
		return a;
	}

	public void setA(Collider a) {
		this.a = a;
	}

	public Collider getB() {
		return b;
	}

	public void setB(Collider b) {
		this.b = b;
	}
}
