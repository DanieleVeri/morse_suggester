package com.galliblock.model;

import java.util.List;

public class ResultCollection {
    private List<Result> list;

    public ResultCollection(List<Result> results) {
        this.list = results;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (Result r :
                list) {
            string.append(r.toString() + "\n");
        }
        return string.toString();
    }

    public String toMorse() {
        StringBuilder string = new StringBuilder();
        for (Result r :
                list) {
            string.append(r.toMorse() + "   ");
        }
        return string.toString().trim();
    }
}
