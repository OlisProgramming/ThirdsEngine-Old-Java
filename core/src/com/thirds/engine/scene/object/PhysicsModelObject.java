package com.thirds.engine.scene.object;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.physics.PhysicsObject;

public class PhysicsModelObject extends ModelRenderObject {

	protected PhysicsObject physicsObject;

	public PhysicsModelObject(PhysicsObject physicsObject, ModelInstance model) {
		super(model);
		this.physicsObject = physicsObject;
	}
	
	public PhysicsModelObject(PhysicsObject physicsObject, Model model) {
		super(model, new Vector3());
		this.physicsObject = physicsObject;
	}
	
	public PhysicsObject getPhysicsObject() {
		return physicsObject;
	}
	
	@Override
	public void tick() {
		super.tick();
		physicsObject.getVelocity().y -= 0.3f;
		physicsObject.simulate();
		model.transform.setTranslation(physicsObject.getPos());
	}
}
