package com.thirds.engine.scene.object;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.thirds.engine.ThirdsEngine;

public class ModelRenderObject extends GameObject {

	/**
	 * Model instance, NOT a model.
	 */
	protected ModelInstance model;
	
	public ModelRenderObject(ModelInstance model) {
		this.model = model;
	}
	
	public ModelRenderObject(Model model) {
		this(model, new Vector3());
	}
	
	public ModelRenderObject(Model model, Vector3 position) {
		this(model, position, new Quaternion(), new Vector3(1f, 1f, 1f));
	}
	
	public ModelRenderObject(Model model, Vector3 position, Quaternion rotation) {
		this(model, position, rotation, new Vector3(1f, 1f, 1f));
	}
	
	public ModelRenderObject(Model model, Vector3 position, Vector3 scale) {
		this(model, position, new Quaternion(), scale);
	}
	
	public ModelRenderObject(Model model, Vector3 position, Quaternion rotation, Vector3 scale) {
		this.model = new ModelInstance(model);
		this.model.transform = new Matrix4(position, rotation, scale);
	}
	
	public ModelInstance getModel() {
		return model;
	}
	
	@Override
	public void render() {
		super.render();
		ThirdsEngine.game.batch.render(model, ThirdsEngine.game.getScene().getEnvironment());
	}
}
