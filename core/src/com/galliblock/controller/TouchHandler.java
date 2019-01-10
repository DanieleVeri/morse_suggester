package com.galliblock.controller;

import com.galliblock.model.Bip;
import com.galliblock.view.TouchDetector;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class TouchHandler extends Observable implements Observer {

    private TouchDetector detector;

    private Calendar startClick;
    private List<Bip> bipList;

    public TouchHandler() {
        bipList = new ArrayList<Bip>();
    }

    public List<Bip> getBipList() {
        return bipList;
    }

    @Override
    public void update(Observable o, Object arg) {
        detector = (TouchDetector) o;
        if (detector.isClicked()) {
            // Start click
            startClick = Calendar.getInstance();
        } else {
            // End click
            bipList.add(new Bip(startClick, Calendar.getInstance()));
            processBipList();
        }
    }

    private void processBipList() {
        if (bipList.size() == 5) {
            setChanged();
            notifyObservers();
            bipList.clear();
        }
    }
}
