package com.thirds.engine;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class ThirdsEngine extends ApplicationAdapter {
	
	private PerspectiveCamera camera;
	
	private ModelBatch batch;
	private Environment environment;
	
	private CameraInputController camController;
	
	private Model model;
	private ModelInstance instance;
	
	@Override
    public void create() {
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
        
        batch = new ModelBatch();
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.1f, 0.1f, 0.1f, 1f));
        //environment.set(new ColorAttribute(ColorAttribute.Specular, 1f, 1f, 1f, 1f));
        environment.add(new PointLight().set(1f, 1f, 1f, 8f, 6f, 7f, 100f));
        
        camController = new CameraInputController(camera);
        Gdx.input.setInputProcessor(camController);
        
        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createBox(5f, 5f, 5f,
            new Material(
            		ColorAttribute.createDiffuse(Color.GREEN),
            		ColorAttribute.createSpecular(Color.WHITE)),
            Usage.Position | Usage.Normal);
        instance = new ModelInstance(model);
    }

    @Override
    public void render() {
    	camController.update();
    	
    	Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        batch.begin(camera);
        batch.render(instance, environment);
        batch.end();
    }

    @Override
    public void pause() {
    }
    
    @Override
    public void resume() {
    }

    @Override
    public void resize(int width, int height) {
    	camera.viewportWidth = width;
    	camera.viewportHeight = height;
    	camera.update();
    }

    @Override
    public void dispose() {
    	batch.dispose();
    	model.dispose();
    }
}
