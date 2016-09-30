package com.thirds.engine.scene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.thirds.engine.Renderable;
import com.thirds.engine.scene.object.GameObject;

public class Scene implements Renderable, Disposable {
	
	private Array<GameObject> objects;
	private Environment environment;
	
	public Scene() {
		// False means an unordered list of objects.
		// Omit argument if ordering is necessary.
		objects = new Array<GameObject>(false, 50);
		environment = new Environment();
	}
	
	public void addObject(GameObject object) {
		objects.add(object);
	}
	
	public void setAmbientLight(float intensity) {
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.1f, 0.1f, 0.1f, 1f));
	}
	
	public void addPointLight(float x, float y, float z, float intensity) {
		this.addPointLight(Color.WHITE, x, y, z, intensity);
	}
	
	public void addPointLight(Color color, float x, float y, float z, float intensity) {
		environment.add(new PointLight().set(color, x, y, z, intensity));
	}
	
	public Environment getEnvironment() {
		return environment;
	}
	
	@Override
	public void tick() {
		for (GameObject object : objects)
			object.tick();
	}
	
	@Override
	public void render() {
		for (GameObject object : objects)
			object.render();
	}
	
	@Override
	public void dispose() {
		for (GameObject object : objects)
			object.dispose();
	}
}
