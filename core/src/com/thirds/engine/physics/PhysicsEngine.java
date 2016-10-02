package com.thirds.engine.physics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.thirds.engine.ThirdsEngine;
import com.thirds.engine.physics.PhysicsObject.PhysicsSimulationType;
import com.thirds.engine.physics.collider.Collider;

public class PhysicsEngine implements Simulatable {

	public static final Vector3 GRAVITY_PER_SECOND = new Vector3(0f, -9.81f, 0f);
	public static final Vector3 GRAVITY_PER_TICK = new Vector3(0f, -9.81f * ThirdsEngine.SECONDS_PER_TICK, 0f);
	private Array<PhysicsObject> objects;
	
	public PhysicsEngine() {
		objects = new Array<PhysicsObject>();
	}
	
	public void addObject(PhysicsObject object) {
		objects.add(object);
	}
	
	public Array<PhysicsObject> getObjects() {
		return objects;
	}

	/**
	 * Simulate all physics objects.
	 */
	@Override
	public void simulate() {
		for (PhysicsObject object : objects)
			object.simulate();
	}
	
	private Array<CollisionData> detectCollisions() {
		Array<CollisionData> collisions = new Array<CollisionData>();
		
		for (int i = 0; i < objects.size; i++) {
			for (int j = i+1; j < objects.size; j++) {
				CollisionData data =
						((Collider)objects.get(i).getCollider()).collide
						((Collider)objects.get(j).getCollider());
				
				if (data.getDoesIntersect())
					collisions.add(data);
			}
		}
		
		return collisions;
	}
	
	private Vector3 reflect(Vector3 vector, Vector3 normal) {
		return vector.cpy().sub(normal.cpy().scl(vector.cpy().dot(normal)).scl(2f));
	}
	
	private void respondToCollisions(Array<CollisionData> collisions) {
		for (CollisionData collision : collisions) {
			Vector3 direction = collision.getDirection().nor();
			
			if (collision.getA().getOwner().getSimType() != PhysicsSimulationType.STATIC)
				collision.getA().getOwner().setVelocity(reflect(collision.getA().getOwner().getVelocity(), direction));
			if (collision.getB().getOwner().getSimType() != PhysicsSimulationType.STATIC)
				collision.getB().getOwner().setVelocity(reflect(collision.getB().getOwner().getVelocity(), direction.scl(-1f)));
			
			Gdx.app.log(collision.getA().toString(), collision.getB().toString());
		}
	}
	
	public void handleCollisions() {
		respondToCollisions(detectCollisions());
	}
}
