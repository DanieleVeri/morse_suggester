package com.galliblock.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class TextFeedback {

    private SpriteBatch batch;
    private BitmapFont font;

    public String input = "";
    public String output = "";

    public TextFeedback(SpriteBatch batch) {
        this.batch = batch;

        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/airstrike.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 25;
        parameter.flip = true;
        font = generator.generateFont(parameter);
        generator.dispose();
    }

    public void render() {
        batch.begin();
        font.draw(batch, "INPUT DATA:\n" + input + "\n\n" + "SOLUTION:\n" + output, 20, 40);
        batch.end();
    }
}
