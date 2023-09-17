package com.javier.entities;

import org.junit.jupiter.api.Test;

import com.javier.enums.Heading;

public class CleaningRobotTest {
    @Test
    public void shouldMoveForward() {
        CleaningRobot cleaningRobotNorth = new CleaningRobot(0, 0, Heading.N);

        cleaningRobotNorth.moveForward();

        assert cleaningRobotNorth.x() == 0;
        assert cleaningRobotNorth.y() == 1;

        CleaningRobot cleaningRobotEast = new CleaningRobot(0, 0, Heading.E);

        cleaningRobotEast.moveForward();

        assert cleaningRobotEast.x() == 1;
        assert cleaningRobotEast.y() == 0;

        CleaningRobot cleaningRobotSouth = new CleaningRobot(0, 0, Heading.S);

        cleaningRobotSouth.moveForward();

        assert cleaningRobotSouth.x() == 0;
        assert cleaningRobotSouth.y() == -1;

        CleaningRobot cleaningRobotWest = new CleaningRobot(0, 0, Heading.W);

        cleaningRobotWest.moveForward();

        assert cleaningRobotWest.x() == -1;
        assert cleaningRobotWest.y() == 0;
    }

    @Test
    public void shouldRotateLeft() {
        CleaningRobot cleaningRobotNorth = new CleaningRobot(0, 0, Heading.N);

        cleaningRobotNorth.rotateLeft();

        assert cleaningRobotNorth.heading() == Heading.W;

        CleaningRobot cleaningRobotEast = new CleaningRobot(0, 0, Heading.E);

        cleaningRobotEast.rotateLeft();

        assert cleaningRobotEast.heading() == Heading.N;

        CleaningRobot cleaningRobotSouth = new CleaningRobot(0, 0, Heading.S);

        cleaningRobotSouth.rotateLeft();

        assert cleaningRobotSouth.heading() == Heading.E;

        CleaningRobot cleaningRobotWest = new CleaningRobot(0, 0, Heading.W);

        cleaningRobotWest.rotateLeft();

        assert cleaningRobotWest.heading() == Heading.S;
    }

    @Test
    public void shouldRotateRight() {
        CleaningRobot cleaningRobotNorth = new CleaningRobot(0, 0, Heading.N);

        cleaningRobotNorth.rotateRight();

        assert cleaningRobotNorth.heading() == Heading.E;

        CleaningRobot cleaningRobotEast = new CleaningRobot(0, 0, Heading.E);

        cleaningRobotEast.rotateRight();

        assert cleaningRobotEast.heading() == Heading.S;

        CleaningRobot cleaningRobotSouth = new CleaningRobot(0, 0, Heading.S);

        cleaningRobotSouth.rotateRight();

        assert cleaningRobotSouth.heading() == Heading.W;

        CleaningRobot cleaningRobotWest = new CleaningRobot(0, 0, Heading.W);

        cleaningRobotWest.rotateRight();

        assert cleaningRobotWest.heading() == Heading.N;
    }
}
