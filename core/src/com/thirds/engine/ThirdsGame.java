package com.thirds.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Disposable;
import com.thirds.engine.scene.Scene;

public class ThirdsGame implements Renderable, Disposable {

	protected PerspectiveCamera camera;
	
	protected Scene scene;
	public ModelBatch batch;
	
	protected GameState state;
	
	public ThirdsGame() {
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		scene = new Scene();
		batch = new ModelBatch();
		state = new GameState();
	}
	
	public Scene getScene() {
		return scene;
	}

	@Override
	public void preTick() {
		if (!state.isPaused())
			scene.preTick();
	}
	
	@Override
	public void tick() {
		if (!state.isPaused())
			scene.tick();
	}
	
	@Override
	public void postTick() {
		if (!state.isPaused())
			scene.postTick();
	}
	
	@Override
	public void render() {    	
    	Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
	}
	
	public void pause() {
		state.setPaused(true);
	}
	
	public void resume() {
	}
	
	public void resize(int width, int height) {
		camera.viewportWidth = width;
    	camera.viewportHeight = height;
    	camera.update();
	}
	
	@Override
	public void dispose() {
		batch.dispose();
	}
}
