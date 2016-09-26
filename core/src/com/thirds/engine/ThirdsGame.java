package com.thirds.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.utils.Disposable;

public class ThirdsGame implements Renderable, Disposable {

	protected PerspectiveCamera camera;
	
	protected ModelBatch batch;
	protected Environment environment;
	
	public ThirdsGame() {
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch = new ModelBatch();
        environment = new Environment();
	}

	@Override
	public void tick() {
	}
	
	@Override
	public void render() {    	
    	Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
	}
	
	public void pause() {
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
