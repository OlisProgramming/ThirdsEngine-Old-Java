package com.thirds.engine;

public interface Renderable {
	
	/**
	 * Update this instance before the normal update code.
	 * Is called at a rate of 60 times per second.
	 */
	public void preTick();
	
	/**
	 * Update this instance.
	 * Is called at a rate of 60 times per second.
	 */
	public void tick();
	
	/**
	 * Update this instance after the normal update code.
	 * Is called at a rate of 60 times per second.
	 */
	public void postTick();
	
	/**
	 * Do all rendering for this instance.
	 */
	public void render();
}
