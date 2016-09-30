package com.thirds.engine.physics;

import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.ThirdsEngine;

public class PhysicsObject implements Simulatable {

	public static enum PhysicsSimulationType {
		STATIC,
		DYNAMIC
	}
	
	private PhysicsSimulationType simType;
	private Vector3 pos;
	private Vector3 velocity;
	
	public PhysicsObject(Vector3 pos) {
		this(pos, PhysicsSimulationType.DYNAMIC);
	}
	
	public PhysicsObject(Vector3 pos, PhysicsSimulationType simType) {
		this.pos = pos;
		this.simType = simType;
		velocity = new Vector3(1f, 2f, 3f);
	}

	@Override
	public void simulate() {
		if (simType == PhysicsSimulationType.STATIC) {
			// Do nothing for static objects
		} else if (simType == PhysicsSimulationType.DYNAMIC) {
			pos.add(velocity.scl(ThirdsEngine.SECONDS_PER_TICK));
		}
	}
	
	public Vector3 getPos() {
		return pos;
	}

	public Vector3 getVelocity() {
		return velocity;
	}
}
