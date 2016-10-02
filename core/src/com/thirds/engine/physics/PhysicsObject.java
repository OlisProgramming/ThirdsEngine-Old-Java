package com.thirds.engine.physics;

import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.ThirdsEngine;
import com.thirds.engine.physics.collider.Collider;

public class PhysicsObject implements Simulatable {

	public static enum PhysicsSimulationType {
		STATIC,
		DYNAMIC
	}
	
	private PhysicsSimulationType simType;
	private Vector3 pos;
	private Vector3 velocity;
	private Collider collider;
	private boolean isColliding;
	
	public PhysicsObject() {
		this(new Vector3());
	}
	
	public PhysicsObject(Vector3 pos) {
		this(pos, PhysicsSimulationType.DYNAMIC);
	}
	
	public PhysicsObject(Vector3 pos, PhysicsSimulationType simType) {
		this.pos = pos;
		this.simType = simType;
		velocity = new Vector3();
	}

	@Override
	public void simulate() {
		if (simType == PhysicsSimulationType.STATIC) {
			// Do nothing for static objects
		} else if (simType == PhysicsSimulationType.DYNAMIC) {
			// Change velocity to add gravity
			if (!isColliding) velocity.add(PhysicsEngine.GRAVITY_PER_TICK);
			
			// Cap velocity to 500 m/s
			velocity.clamp(0f, PhysicsEngine.VELOCITY_CAP);
			
			// Change pos due to velocity
			pos.add(velocity.cpy().scl(ThirdsEngine.SECONDS_PER_TICK));
			collider.setPos(pos);
			
			// isColliding must only be true for one tick
			isColliding = false;
		}
	}
	
	public PhysicsSimulationType getSimType() {
		return simType;
	}

	public void setSimType(PhysicsSimulationType simType) {
		this.simType = simType;
	}

	public Collider getCollider() {
		return collider;
	}

	public void setCollider(Collider collider) {
		this.collider = collider;
	}

	public Vector3 getPos() {
		return pos;
	}

	public void setPos(Vector3 pos) {
		this.pos = pos;
	}
	
	public Vector3 getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector3 velocity) {
		this.velocity = velocity;
	}

	public boolean isColliding() {
		return isColliding;
	}

	public void setColliding(boolean isColliding) {
		this.isColliding = isColliding;
	}
}
