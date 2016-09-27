package com.thirds.engine.scene.object;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.thirds.engine.ThirdsEngine;

public class ModelRenderObject extends GameObject {

	private ModelInstance model;
	
	public ModelRenderObject(ModelInstance model) {
		this.model = model;
	}
	
	public ModelRenderObject(Model model) {
		this.model = new ModelInstance(model);
	}
	
	@Override
	public void render() {
		super.render();
		ThirdsEngine.game.batch.render(model, ThirdsEngine.game.environment);
	}
}
