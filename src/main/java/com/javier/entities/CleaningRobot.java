package com.javier.entities;

import com.javier.enums.Heading;

public record CleaningRobot(int x, int y, Heading heading) {
    @Override
    public String toString() {
        return String.format("%d %d %s", x, y, heading);
    }
}
