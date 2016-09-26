package com.thirds.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.thirds.game.TestGame;
import com.thirds.game.ThirdsGame;

public class ThirdsEngine extends ApplicationAdapter {
	
	private ThirdsGame game;
	
	public static final int TICKS_PER_SECOND = 60;
	public static final float SECONDS_PER_TICK = 1f / TICKS_PER_SECOND;
	
	@Override
    public void create() {
		game = new TestGame();
    }

    @Override
    public void render() {
    	game.render();
    }

    @Override
    public void pause() {
    	game.pause();
    }
    
    @Override
    public void resume() {
    	game.resume();
    }

    @Override
    public void resize(int width, int height) {
    	game.resize(width, height);
    }

    @Override
    public void dispose() {
    	game.dispose();
    }
}
