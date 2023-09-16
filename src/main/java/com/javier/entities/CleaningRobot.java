package com.javier.entities;

public record CleaningRobot(int x, int y, Heading heading) {
    @Override
    public String toString() {
        return String.format("%d %d %s", x, y, heading);
    }
}
