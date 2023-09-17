package com.javier.entities;

import com.javier.enums.Heading;

public class CleaningRobot {
    private int x;
    private int y;
    private Heading heading;

    public CleaningRobot(int x, int y, Heading heading) {
        this.x = x;
        this.y = y;
        this.heading = heading;
    }

    @Override
    public String toString() {
        return String.format("%d %d %s", x, y, heading);
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public Heading heading() {
        return heading;
    }

    public void moveForward() {
        switch (heading) {
            case NORTH:
                y++;
                break;
            case EAST:
                x++;
                break;
            case SOUTH:
                y--;
                break;
            case WEST:
                x--;
                break;
        }
    }

    public void rotateLeft() {
        switch (heading) {
            case NORTH:
                heading = Heading.WEST;
                break;
            case EAST:
                heading = Heading.NORTH;
                break;
            case SOUTH:
                heading = Heading.EAST;
                break;
            case WEST:
                heading = Heading.SOUTH;
                break;
        }
    }

    public void rotateRight() {
        switch (heading) {
            case NORTH:
                heading = Heading.EAST;
                break;
            case EAST:
                heading = Heading.SOUTH;
                break;
            case SOUTH:
                heading = Heading.WEST;
                break;
            case WEST:
                heading = Heading.NORTH;
                break;
        }
    }
}
