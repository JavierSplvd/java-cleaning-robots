package com.javier.entities;

import com.javier.enums.Heading;

public class CleaningRobot {
    private Vector2 position;
    private Heading heading;

    public CleaningRobot(int x, int y, Heading heading) {
        this.position = new Vector2(x, y);
        this.heading = heading;
    }

    public Vector2 position() {
        return position;
    }

    public Heading heading() {
        return heading;
    }

    public void moveForward(MoveForwardAction action) {
        this.position = action.getNewPosition();
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
