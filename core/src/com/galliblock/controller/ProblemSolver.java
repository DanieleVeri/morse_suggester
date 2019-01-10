package com.galliblock.controller;

import com.galliblock.model.ArchiveSolutions;
import com.galliblock.model.ResultCollection;
import com.galliblock.view.TextFeedback;
import com.galliblock.view.Vibrator;

import java.util.Observable;
import java.util.Observer;

public class ProblemSolver implements Observer {

    private Vibrator vibrator;
    private ArchiveSolutions archiveSolutions;
    private TextFeedback textOutput;

    public ProblemSolver(TextFeedback textOutput, Vibrator vibrator, ArchiveSolutions archiveSolutions) {
        this.vibrator = vibrator;
        this.archiveSolutions = archiveSolutions;
        this.textOutput = textOutput;
    }

    @Override
    public void update(Observable o, Object arg) {
        MorseParser morseParser = (MorseParser) o;
        ResultCollection results;

        try {
            results = archiveSolutions.solve(morseParser.getNumberList());
            textOutput.output = results.toString();
            vibrator.process(results.toMorse());

        } catch (Exception e) {
            vibrator.error(Vibrator.ErrorCode.ILLEGAL_ES);
            e.printStackTrace();
        }
    }
}
