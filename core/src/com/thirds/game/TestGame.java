package com.thirds.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.thirds.engine.ThirdsEngine;
import com.thirds.engine.ThirdsGame;
import com.thirds.engine.scene.object.ModelRenderObject;

public class TestGame extends ThirdsGame {
	
	private CameraInputController camController;
	
	private Model model;
	
	public TestGame() {
		super();
		
        camera.position.set(10f, 10f, 10f);
        camera.lookAt(0, 0, 0);
        camera.near = 1f;
        camera.far = 300f;
        camera.update();
        
        scene.getEnvironment().set(new ColorAttribute(ColorAttribute.AmbientLight, 0.1f, 0.1f, 0.1f, 1f));
        scene.getEnvironment().set(new ColorAttribute(ColorAttribute.Specular, 1f, 1f, 1f, 1f));
        scene.getEnvironment().add(new PointLight().set(1f, 1f, 1f, 8f, 6f, 7f, 100f));
        
        camController = new CameraInputController(camera);
        ThirdsEngine.inputMux.addProcessor(camController);
        
        ModelBuilder modelBuilder = new ModelBuilder();
        model = modelBuilder.createBox(5f, 5f, 5f,
            new Material(
            		ColorAttribute.createDiffuse(Color.GREEN),
            		ColorAttribute.createSpecular(Color.WHITE)),
            Usage.Position | Usage.Normal);
        scene.addObject(new ModelRenderObject(model));
	}
	
	@Override
	public void tick() {
		super.tick();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		model.dispose();
	}
}
