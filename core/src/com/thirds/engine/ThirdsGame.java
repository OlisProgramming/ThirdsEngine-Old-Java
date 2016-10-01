package com.thirds.engine;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.thirds.engine.scene.Scene;

public class ThirdsGame implements Renderable, Disposable {

	protected PerspectiveCamera camera;
	
	protected Scene scene;
	public ModelBatch batch;
	private SpriteBatch menuBatch;
	
	private Stage pauseMenu;
	private Container<VerticalGroup> menuContainer;
    private BitmapFont font;
	
	protected GameState state;
	
	public ThirdsGame() {
		camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		scene = new Scene();
		batch = new ModelBatch();
		menuBatch = new SpriteBatch();
		
		pauseMenu = new Stage(new ScreenViewport());
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		
		Label pausedLabel = new Label("RESUME GAME", new LabelStyle(font, Color.WHITE));
		Label quitLabel = new Label("QUIT", new LabelStyle(font, Color.WHITE));
		
		pausedLabel.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				state.setPaused(false);
			}
		});
		quitLabel.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				// TODO add an 'Are you sure you want to Quit?' box
				Gdx.app.exit();
			}
		});
		
		VerticalGroup menuGroup = new VerticalGroup();
		menuGroup.addActor(pausedLabel);
		menuGroup.addActor(quitLabel);
		menuGroup.space(64f);
		
		menuContainer = new Container<VerticalGroup>(menuGroup);
		menuContainer.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		
		pauseMenu.addActor(menuContainer);
		
		state = new GameState();
		
		ThirdsEngine.inputMux.addProcessor(pauseMenu);
	}
	
	public Scene getScene() {
		return scene;
	}
	
	@Override
	public void tick() {
		scene.tick();
	}
	
	@Override
	public void render() {    	
    	Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        
        batch.begin(camera);
        renderScene();
        batch.end();
        
        if (state.isPaused()) {
	        menuBatch.begin();
	        renderMenu();
	        menuBatch.end();
        }
	}
	
	protected void renderScene() {
		scene.render();
	}
	
	/**
	 * Draw pause menu.
	 */
	protected void renderMenu() {
		pauseMenu.draw();
	}
	
	public void pause() {
		state.setPaused(true);
	}
	
	public void resume() {
	}
	
	public void resize(int width, int height) {
		camera.viewportWidth = width;
    	camera.viewportHeight = height;
    	camera.update();
    	
    	menuContainer.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}
	
	@Override
	public void dispose() {
		batch.dispose();
		scene.dispose();
	}
}
