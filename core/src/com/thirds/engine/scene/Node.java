package com.thirds.engine.scene;

import com.badlogic.gdx.utils.Array;
import com.thirds.engine.Renderable;
import com.thirds.engine.scene.component.Component;

public class Node implements Renderable {

	private Array<Node> children;
	private Array<Component> components;
	
	public Node() {
		children = new Array<Node>();
		components = new Array<Component>();
	}
	
	public void addChild(Node child) {
		children.add(child);
	}
	
	public void addComponent(Component component) {
		component.setNode(this);
		components.add(component);
	}
	
	@Override
	public void tick() {
		for (Component component : components)
			component.tick();
		
		for (Node child : children)
			child.tick();
	}
	
	@Override
	public void render() {
		for (Component component : components)
			component.render();
		
		for (Node child : children)
			child.render();
	}
}
