package com.thirds.engine.scene.component;

import com.thirds.engine.Renderable;
import com.thirds.engine.scene.Node;

public class Component implements Renderable {
	
	protected Node node;
	
	/**
	 * Initialise this component.
	 */
	public void init() {
	}
	
	@Override
	public void tick() {
	}
	
	@Override
	public void render() {
	}
	
	/**
	 * Set the node that this component is bound to.
	 */
	public void setNode(Node node) {
		this.node = node;
	}
}
