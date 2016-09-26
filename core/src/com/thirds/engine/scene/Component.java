package com.thirds.engine.scene;

import com.thirds.engine.Renderable;

public interface Component extends Renderable {
	/**
	 * Initialise this component.
	 */
	public void init();
}
