package com.thirds.engine;

public interface Renderable {
	/**
	 * Update this instance.
	 * Is called at a rate of 60 times per second.
	 */
	public void tick();
	
	/**
	 * Do all rendering for this instance.
	 */
	public void render();
}
