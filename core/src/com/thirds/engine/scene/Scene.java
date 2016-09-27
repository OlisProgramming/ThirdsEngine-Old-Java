package com.thirds.engine.scene;

import com.thirds.engine.Renderable;

public class Scene implements Renderable {
	
	private Node scene;
	
	public void addObject(Node object) {
		scene.addChild(object);
	}
	
	@Override
	public void tick() {
		scene.tick();
	}
	
	@Override
	public void render() {
		scene.render();
	}
}
