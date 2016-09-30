package com.thirds.engine.physics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.ThirdsEngine;
import com.thirds.engine.physics.collider.Collider;
import com.thirds.engine.physics.collider.SphereCollider;

public class PhysicsObject implements Simulatable {

	public static enum PhysicsSimulationType {
		STATIC,
		DYNAMIC
	}
	
	private PhysicsSimulationType simType;
	private Vector3 pos;
	private Vector3 velocity;
	private Collider collider;
	
	public PhysicsObject(Vector3 pos, Collider collider) {
		this(pos, collider, PhysicsSimulationType.DYNAMIC);
	}
	
	public PhysicsObject(Vector3 pos, Collider collider, PhysicsSimulationType simType) {
		this.pos = pos;
		this.collider = collider;
		if (collider instanceof SphereCollider)
			((SphereCollider) collider).setPos(pos);
		else
			Gdx.app.error("UNIMPLEMENTED", "Colliders apart from SphereCollider");
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

	public void setPos(Vector3 pos) {
		this.pos = pos;
	}
	
	public Vector3 getVelocity() {
		return velocity;
	}
	
	public void setVelocity(Vector3 velocity) {
		this.velocity = velocity;
	}
}
