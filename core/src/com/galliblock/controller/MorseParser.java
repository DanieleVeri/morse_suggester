package com.galliblock.controller;

import com.galliblock.view.TextFeedback;
import com.galliblock.view.Vibrator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class MorseParser extends Observable implements Observer {

    private Map<String, Integer> map;
    private List<Integer> numberList;
    private Vibrator vibrator;
    private TextFeedback textOutput;

    public MorseParser(TextFeedback textOutput, Vibrator vibrator) {
        numberList = new ArrayList<Integer>();
        populateMap();
        this.vibrator = vibrator;
        this.textOutput = textOutput;
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    @Override
    public void update(Observable o, Object arg) {
        TouchHandler touchHandler = (TouchHandler) o;
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < touchHandler.getBipList().size(); i++) {
            if (touchHandler.getBipList().get(i).isLong()) {
                builder.append("-");
            } else {
                builder.append(".");
            }
        }

        if (map.get(builder.toString()) != null) {
            numberList.add(map.get(builder.toString()));
            textOutput.input = makeInputString();
            processNumberList();
        } else {
            vibrator.error(Vibrator.ErrorCode.ILLEGAL_NUM);
        }
    }

    private void processNumberList() {
        if (numberList.size() == 6) {
            setChanged();
            notifyObservers();
            numberList.clear();
        }
    }

    private void populateMap() {
        map = new HashMap<String, Integer>();

        map.put("-----", 0);
        map.put(".----", 1);
        map.put("..---", 2);
        map.put("...--", 3);
        map.put("....-", 4);
        map.put(".....", 5);
        map.put("-....", 6);
        map.put("--...", 7);
        map.put("---..", 8);
        map.put("----.", 9);
    }

    private String makeInputString() {
        String es = "Es: ", epsilon = "Epsilon: ";
        try {

            es += numberList.get(0).toString();
            es += "-" + numberList.get(1).toString();
            es += numberList.get(2).toString();
            epsilon += numberList.get(3).toString();
            epsilon += numberList.get(4).toString();
            epsilon += numberList.get(5).toString();

        } catch (IndexOutOfBoundsException unused) {}
        return es + "\n" + epsilon;
    }
}
