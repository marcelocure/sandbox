package com.github.marcelocure.java8optional.model;

import java.util.Optional;

public class Car {
    private int valves;
    private int speed;
    private Optional<Model> model;

    public Car(int valves, int speed, Model model) {
        this.valves = valves;
        this.speed = speed;
        this.model = Optional.ofNullable(model);
    }

    public int getValves() {
        return valves;
    }

    public void setValves(int valves) {
        this.valves = valves;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Optional<Model> getModel() {
        return model;
    }

    public void setModel(Optional<Model> model) {
        this.model = model;
    }
}
