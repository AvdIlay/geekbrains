package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Race {
    private final ArrayList<Stage> stages;
    Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }
}