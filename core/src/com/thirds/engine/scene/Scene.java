package com.thirds.engine.scene;

public class Scene {
	
	private Node scene;
	
	public void addObject(Node object) {
		scene.addChild(object);
	}
}
