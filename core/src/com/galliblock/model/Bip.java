package com.galliblock.model;

import java.util.Calendar;

public class Bip {

    private Calendar start, end;
    private float last;
    private boolean isLong = false;

    public Bip(Calendar start, Calendar end) {
        this.start = start;
        this.end = end;
        last = (end.getTimeInMillis() - start.getTimeInMillis()) / 1000f;
        if (last > .5) {
            isLong = true;
        }
    }

    public Calendar getStart() {
        return start;
    }

    public Calendar getEnd() {
        return end;
    }

    public float getLast() {
        return last;
    }

    public boolean isLong() {
        return isLong;
    }
}
