package com.thirds.engine;

public class GameState {

	/**
	 * States whether or not the game is paused.
	 * This does NOT mean the same as the LibGDX
	 * <code>pause</code> event, however this
	 * variable is true when the user has paused
	 * the game (i.e. the pause menu)
	 */
	private boolean paused;
	
	public GameState() {
		paused = false;
	}

	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
	}
}
