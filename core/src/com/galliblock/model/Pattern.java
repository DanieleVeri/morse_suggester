package com.galliblock.model;

import java.util.Calendar;

public class Pattern {

    private long[] pattern;
    private Calendar start;
    public boolean isInterrupted;

    public Pattern(long[] pattern) {
        this.pattern = pattern;
    }

    public void play() {
        start = Calendar.getInstance();
        isInterrupted = false;
    }

    public long[] getPattern() {
        return pattern;
    }

    private long getLast() {
        long last = 0;
        for (long l :
                pattern) {
            last += l;
        }
        return last;
    }

    public boolean isStillPlaying() {
        return Calendar.getInstance().getTimeInMillis() - start.getTimeInMillis() < getLast();
    }
}
