package com.thirds.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.thirds.game.TestGame;
import com.thirds.game.ThirdsGame;

public class ThirdsEngine extends ApplicationAdapter {
	
	private ThirdsGame game;
	
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
