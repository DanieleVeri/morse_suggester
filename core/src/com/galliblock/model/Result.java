package com.galliblock.model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Result {

    private int prePoint;
    private int firstPostPoint;
    private int secondPostPoint;

    private boolean isExponentialNegative;
    private int firstExponential;
    private int secondExponential;

    private static Map<Integer,String> map = new HashMap<Integer, String>();

    public Result(double value) {
        boolean isExpNegative = false;
        try {
            StringTokenizer s = new StringTokenizer(new DecimalFormat("0.00E00").format(value));
            this.prePoint = Integer.valueOf(s.nextToken(","));
            s.nextToken("0123456789");
            int pointNumber = Integer.valueOf(s.nextToken("E"));
            this.firstPostPoint = pointNumber/10;
            this.secondPostPoint = pointNumber%10;
            int expNumber = Integer.valueOf(s.nextToken());
            this.isExponentialNegative = expNumber < 0;
            this.firstExponential = expNumber/10;
            this.secondExponential = Math.abs(expNumber)%10;
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        populateMap();
    }

    @Override
    public String toString() {
        return prePoint+"."+firstPostPoint+secondPostPoint+" E "+
                (isExponentialNegative ? "-":"")+firstExponential+secondExponential;
    }


    public String toMorse() {
        StringBuilder str = new StringBuilder();
        str.append(prePoint<0?"- ":"").append(map.get(Math.abs(prePoint)) + " ").append(map.get(firstPostPoint) + " ").
                append(map.get(secondPostPoint) + " ").append(isExponentialNegative ? "- ":"").
                append(map.get(Math.abs(firstExponential)) + " ").append(map.get(secondExponential) + " ");
        return str.toString();
    }

    private static void populateMap() {
        if (!map.isEmpty())
            return;

        map.put(0, "-----");
        map.put(1, ".----");
        map.put(2, "..---");
        map.put(3, "...--");
        map.put(4, "....-");
        map.put(5, ".....");
        map.put(6, "-....");
        map.put(7, "--...");
        map.put(8, "---..");
        map.put(9, "----.");
    }
}
