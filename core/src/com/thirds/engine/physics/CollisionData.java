package com.thirds.engine.physics;

import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.collider.Collider;

public class CollisionData {

	private boolean doesIntersect;
	/**
	 * Direction of collision. The length of this vector
	 * is the distance inside each object the collision
	 * occurred at.
	 */
	private Vector3 direction;
	
	private Collider a;
	private Collider b;
	
	public CollisionData(boolean doesIntersect, Vector3 direction, Collider a, Collider b) {
		this.doesIntersect = doesIntersect;
		this.direction = direction;
		setA(a);
		setB(b);
	}
	
	public boolean getDoesIntersect() {
		return doesIntersect;
	}

	public Vector3 getDirection() {
		return direction;
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
