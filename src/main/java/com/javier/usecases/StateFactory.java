package com.javier.usecases;

public class StateFactory {
    public static State create() {
        return new CreateGridState();
    }
}
