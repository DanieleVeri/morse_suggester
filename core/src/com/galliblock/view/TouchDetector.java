package com.galliblock.view;

import com.badlogic.gdx.Gdx;
import java.util.Observable;

public class TouchDetector extends Observable{

    private boolean isClicked;

    public TouchDetector() {
        isClicked = false;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void detect() {
        if (Gdx.input.isTouched() && !isClicked) {
            isClicked = true;
            setChanged();
        }
        if (!Gdx.input.isTouched() && isClicked) {
            isClicked = false;
            setChanged();
        }
        notifyObservers();
    }
}
