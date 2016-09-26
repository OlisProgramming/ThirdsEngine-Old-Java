package com.thirds.engine;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;
import com.thirds.game.TestGame;
import com.thirds.game.ThirdsGame;

public class ThirdsEngine extends ApplicationAdapter {
	
	public static final int TICKS_PER_SECOND = 60;
	public static final float SECONDS_PER_TICK = 1f / TICKS_PER_SECOND;
	public static final float MILLIS_PER_TICK = SECONDS_PER_TICK * 1000f;
	
	private ThirdsGame game;
	
	private long startTime = TimeUtils.millis();
	private long lastFrameTime = startTime;
	private long unprocessedTime = 0L;
	
	@Override
    public void create() {
		game = new TestGame();
    }

    @Override
    public void render() {
    	long frameStartTime = TimeUtils.millis();
    	long passedTime = frameStartTime - lastFrameTime;
    	lastFrameTime = frameStartTime;
    	
    	unprocessedTime += passedTime;
    	
    	while (unprocessedTime >= MILLIS_PER_TICK) {
    		unprocessedTime -= MILLIS_PER_TICK;
    		game.tick();
    	}
    	
    	game.render();
    }

    @Override
    public void pause() {
    	game.pause();
    }
    
    @Override
    public void resume() {
    	game.resume();
    }

    @Override
    public void resize(int width, int height) {
    	game.resize(width, height);
    }

    @Override
    public void dispose() {
    	game.dispose();
    	long runTime = TimeUtils.timeSinceMillis(startTime);
    	float runTimeSeconds = runTime / 1000f;
    	
    	long second = (runTime / 1000) % 60;
    	long minute = (runTime / (1000 * 60)) % 60;
    	long hour = (runTime / (1000 * 60 * 60)) % 24;

    	String runTimeString = String.format("%d hours, %d minutes and %d seconds", hour, minute, second);
    	Gdx.app.log("Total run time", runTimeString);
    }
}
