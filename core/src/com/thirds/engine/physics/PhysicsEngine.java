package com.thirds.engine.physics;

import com.badlogic.gdx.utils.Array;

public class PhysicsEngine implements Simulatable {

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
}
