package com.galliblock;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.galliblock.controller.MorseParser;
import com.galliblock.controller.ProblemSolver;
import com.galliblock.controller.TouchHandler;
import com.galliblock.model.ArchiveSolutions;
import com.galliblock.view.TextFeedback;
import com.galliblock.view.TouchDetector;
import com.galliblock.view.Vibrator;

public class main extends ApplicationAdapter {

	private SpriteBatch batch;
	private OrthographicCamera camera;

	private TouchDetector detector;
	private TouchHandler touchHandler;
	private MorseParser morseParser;
	private ProblemSolver problemSolver;

	private ArchiveSolutions archiveSolutions;

	private Vibrator vibrator;
	private TextFeedback textFeedback;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();
		batch = new SpriteBatch();
		batch.setProjectionMatrix(camera.combined);

		archiveSolutions = new ArchiveSolutions();

		textFeedback = new TextFeedback(batch);
		vibrator = new Vibrator();

		detector = new TouchDetector();
		touchHandler = new TouchHandler();
		detector.addObserver(touchHandler);
		morseParser = new MorseParser(textFeedback, vibrator);
		touchHandler.addObserver(morseParser);
		problemSolver = new ProblemSolver(textFeedback, vibrator, archiveSolutions);
		morseParser.addObserver(problemSolver);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		detector.detect();
		textFeedback.render();
	}

	@Override
	public void pause () {
		vibrator.pause();
	}

	@Override
	public void resume () {
		vibrator.resume();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
