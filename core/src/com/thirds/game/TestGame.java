package com.thirds.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class TestGame extends ThirdsGame {
	
	private CameraInputController camController;
	
	private Model model;
	private ModelInstance instance;
	
	public TestGame() {
		super();
		
        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
        
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.1f, 0.1f, 0.1f, 1f));
        environment.set(new ColorAttribute(ColorAttribute.Specular, 1f, 1f, 1f, 1f));
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
		super.render();
		
		camController.update();

        batch.begin(camera);
        batch.render(instance, environment);
        batch.end();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		model.dispose();
	}
}
