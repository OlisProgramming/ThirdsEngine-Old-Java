package com.thirds.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.ThirdsEngine;
import com.thirds.engine.ThirdsGame;
import com.thirds.engine.physics.PhysicsObject.PhysicsSimulationType;
import com.thirds.engine.physics.PhysicsObjectFactory;
import com.thirds.engine.scene.object.PhysicsModelObject;

public class TestGame extends ThirdsGame {
	
	private CameraInputController camController;
	
	private Model modelFloor, modelSphere;
	
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
        scene.getEnvironment().add(new PointLight().set(1f, 1f, 1f, -4f, 9f, -3f, 50f));
        
        camController = new CameraInputController(camera);
        ThirdsEngine.inputMux.addProcessor(camController);
        
        ModelBuilder modelBuilder = new ModelBuilder();
        modelFloor = modelBuilder.createBox(20f, 1f, 20f,
	            new Material(
	            		ColorAttribute.createDiffuse(Color.GREEN)),
	            Usage.Position | Usage.Normal);
        modelSphere = modelBuilder.createSphere(2f, 2f, 2f, 32, 16,
        		new Material(
        				ColorAttribute.createDiffuse(Color.BLUE)),
        		Usage.Position | Usage.Normal);

        PhysicsModelObject floor = new PhysicsModelObject(
        		PhysicsObjectFactory.createAABB(new Vector3(-10f, -1f, -10f), new Vector3(10f, 0f, 10f)), modelFloor);
        floor.getPhysicsObject().setSimType(PhysicsSimulationType.STATIC);
        scene.addObject(floor);
        scene.addPhysicsObject(floor.getPhysicsObject());
	}
	
	int t = 0;
	@Override
	public void tick() {
		super.tick();
		
		if (t++ > 60) {
			t = 0;
			PhysicsModelObject sphere = new PhysicsModelObject(
					PhysicsObjectFactory.createSphere(new Vector3(
							(float)Math.random(), 10f, (float)Math.random()), 1f), modelSphere);
			scene.addObject(sphere);
			scene.addPhysicsObject(sphere.getPhysicsObject());
		}
	}
	
	@Override
	public void dispose() {
		super.dispose();
		modelFloor.dispose();
		modelSphere.dispose();
	}
}
