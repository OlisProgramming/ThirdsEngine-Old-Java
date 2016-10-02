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
import com.thirds.engine.physics.PhysicsObject;
import com.thirds.engine.physics.PhysicsObjectFactory;
import com.thirds.engine.scene.object.ModelRenderObject;
import com.thirds.engine.scene.object.PhysicsModelObject;

public class TestGame extends ThirdsGame {
	
	private CameraInputController camController;
	
	private Model modelFloor, modelSphere, modelBox;
	
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
        modelBox = modelBuilder.createBox(2f, 2f, 2f,
        		new Material(
        				ColorAttribute.createDiffuse(Color.BLUE)),
        		Usage.Position | Usage.Normal);
        
        scene.addObject(new ModelRenderObject(modelFloor, new Vector3(0f, -0.5f, 0f)));
        
        PhysicsModelObject sphere1 = new PhysicsModelObject(
        		PhysicsObjectFactory.createSphere(new Vector3(5f, 2f, 0.3f), 1f), modelSphere);
//        sphere1.getPhysicsObject().setVelocity(new Vector3(-0.3f, 0f, 0f));
        scene.addObject(sphere1);
        scene.addPhysicsObject(sphere1.getPhysicsObject());
        
        PhysicsModelObject sphere2 = new PhysicsModelObject(
        		PhysicsObjectFactory.createSphere(new Vector3(-5f, 2f, -0.3f), 1f), modelSphere);
//        sphere2.getPhysicsObject().setVelocity(new Vector3(0.3f, 0f, 0f));
        scene.addObject(sphere2);
        scene.addPhysicsObject(sphere2.getPhysicsObject());
        
        ////
        
        PhysicsModelObject box1 = new PhysicsModelObject(
        		PhysicsObjectFactory.createAABB(new Vector3(5f, 5f, -0.3f), 2f, 2f, 2f), modelBox);
//        box1.getPhysicsObject().setVelocity(new Vector3(-0.3f, 0f, 0f));
        scene.addObject(box1);
        scene.addPhysicsObject(box1.getPhysicsObject());
        
        PhysicsModelObject box2 = new PhysicsModelObject(
        		PhysicsObjectFactory.createAABB(new Vector3(-5f, 5f, 0.3f), 2f, 2f, 2f), modelBox);
//        box2.getPhysicsObject().setVelocity(new Vector3(0.3f, 0f, 0f));
        scene.addObject(box2);
        scene.addPhysicsObject(box2.getPhysicsObject());
        
        ////
        
        PhysicsModelObject sphere3 = new PhysicsModelObject(
        		PhysicsObjectFactory.createSphere(new Vector3(-5f, 8f, -0.3f), 1f), modelSphere);
//        sphere3.getPhysicsObject().setVelocity(new Vector3(0.3f, 0f, 0f));
        scene.addObject(sphere3);
        scene.addPhysicsObject(sphere3.getPhysicsObject());
        
        PhysicsModelObject box3 = new PhysicsModelObject(
        		PhysicsObjectFactory.createAABB(new Vector3(5f, 8f, 0.3f), 2f, 2f, 2f), modelBox);
//        box3.getPhysicsObject().setVelocity(new Vector3(-0.3f, 0f, 0f));
        scene.addObject(box3);
        scene.addPhysicsObject(box3.getPhysicsObject());
        
        ////
        
        PhysicsObject plane = PhysicsObjectFactory.createPlane(new Vector3(0f, 1f, 0f), 0f);
        scene.addPhysicsObject(plane);
        
        PhysicsModelObject box4 = new PhysicsModelObject(
        		PhysicsObjectFactory.createAABB(new Vector3(5f, 5f, 3f), 2f, 2f, 2f), modelBox);
//        box4.getPhysicsObject().setVelocity(new Vector3(0f, -0.3f, 0f));
        scene.addObject(box4);
        scene.addPhysicsObject(box4.getPhysicsObject());
        
        PhysicsModelObject sphere4 = new PhysicsModelObject(
        		PhysicsObjectFactory.createSphere(new Vector3(-5f, 5f, 3f), 1f), modelSphere);
//        sphere4.getPhysicsObject().setVelocity(new Vector3(0f, -0.3f, 0f));
        scene.addObject(sphere4);
        scene.addPhysicsObject(sphere4.getPhysicsObject());
	}
	
	@Override
	public void tick() {
		super.tick();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		modelFloor.dispose();
		modelSphere.dispose();
	}
}
