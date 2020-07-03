package com.company;

public abstract class Stage {
    int length;
    String description;
    public abstract void go(Car c);
    String getDescription() {
        return description;
    }
}
