package com.galliblock.view;

import com.badlogic.gdx.Gdx;
import com.galliblock.model.Pattern;

public class Vibrator {

    private static final long delay = 1000;
    private static final long longDelay = 3000;

    private static final long bip = 100;
    private static final long longBip = 300;

    private Pattern pattern;

    public Vibrator() {}

    public enum ErrorCode {
        ILLEGAL_NUM, ILLEGAL_ES
    }

    public void error(ErrorCode code) {
        switch (code) {
            case ILLEGAL_NUM:
                vibrate(new Pattern(new long[]{delay, bip, delay, bip, delay, bip}));
                break;
            case ILLEGAL_ES:
                vibrate(new Pattern(new long[]{delay, longBip, delay, longBip, delay, longBip}));
                break;
            default:
        }
    }

    public void process(String s) {
        long[] pattern = new long[s.length()*2+1];
        int index = 0;
        pattern[index] = delay;
        index ++;
        for (int i = 0; i < s.length(); ++i) {
            // Vibration
            if (s.charAt(i) == '-') {
                pattern[index] = longBip;
            }
            if (s.charAt(i) == '.') {
                pattern[index] = bip;
            }
            if (s.charAt(i) == ' ') {
                pattern[index] = 0;
            }
            index ++;

            // Delay
            if (s.charAt(i) == ' ') {
                pattern[index] = longDelay;
            } else {
                pattern[index] = delay;
            }
            index ++;
        }
        this.pattern = new Pattern(pattern);
        vibrate(this.pattern);
    }

    private void vibrate(Pattern pattern) {
        Gdx.input.vibrate(pattern.getPattern(), -1);
        pattern.play();
    }

    public void pause() {
        if (pattern == null)
            return;
        if (pattern.isStillPlaying()) {
            pattern.isInterrupted = true;
        }
    }

    public void resume() {
        if (pattern == null)
            return;
        if (pattern.isInterrupted) {
            vibrate(pattern);
        }
    }
}
