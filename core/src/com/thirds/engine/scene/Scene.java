package com.thirds.engine.scene;

import com.badlogic.gdx.utils.Array;
import com.thirds.engine.Renderable;
import com.thirds.engine.scene.object.GameObject;

public class Scene implements Renderable {
	
	private Array<GameObject> objects;
	
	public Scene() {
		// False means an unordered list of objects.
		// Omit argument if ordering is necessary.
		objects = new Array<GameObject>(false, 50);
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	@Override
	public void preTick() {
		for (GameObject object : objects)
			object.preTick();
	}
	
	@Override
	public void tick() {
		for (GameObject object : objects)
			object.tick();
	}
	
	@Override
	public void postTick() {
		for (GameObject object : objects)
			object.postTick();
	}
	
	@Override
	public void render() {
		for (GameObject object : objects)
			object.render();
	}
}
