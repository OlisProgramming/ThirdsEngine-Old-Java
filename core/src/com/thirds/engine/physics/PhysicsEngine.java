package com.thirds.engine.physics;

import com.badlogic.gdx.utils.Array;
import com.thirds.engine.Renderable;

public class PhysicsEngine implements Renderable {

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
	public void tick() {
		for (PhysicsObject object : objects)
			object.simulate();
	}

	@Override
	public void render() {
	}
}
