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
            case N:
                y++;
                break;
            case E:
                x++;
                break;
            case S:
                y--;
                break;
            case W:
                x--;
                break;
        }
    }

    public void rotateLeft() {
        switch (heading) {
            case N:
                heading = Heading.W;
                break;
            case E:
                heading = Heading.N;
                break;
            case S:
                heading = Heading.E;
                break;
            case W:
                heading = Heading.S;
                break;
        }
    }

    public void rotateRight() {
        switch (heading) {
            case N:
                heading = Heading.E;
                break;
            case E:
                heading = Heading.S;
                break;
            case S:
                heading = Heading.W;
                break;
            case W:
                heading = Heading.N;
                break;
        }
    }

    public static CleaningRobot of(String positionAsText) {
        String[] position = positionAsText.split(" ");
        int x = Integer.parseInt(position[0]);
        int y = Integer.parseInt(position[1]);
        Heading heading = Heading.valueOf(position[2]);
        return new CleaningRobot(x, y, heading);
    }
}
