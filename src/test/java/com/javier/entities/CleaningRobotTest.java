package com.javier.entities;

import org.junit.jupiter.api.Test;

import com.javier.enums.Heading;

public class CleaningRobotTest {
    @Test
    public void shouldMoveForward() {
        CleaningRobot cleaningRobotNorth = new CleaningRobot(0, 0, Heading.NORTH);

        cleaningRobotNorth.moveForward();

        assert cleaningRobotNorth.x() == 0;
        assert cleaningRobotNorth.y() == 1;

        CleaningRobot cleaningRobotEast = new CleaningRobot(0, 0, Heading.EAST);

        cleaningRobotEast.moveForward();

        assert cleaningRobotEast.x() == 1;
        assert cleaningRobotEast.y() == 0;

        CleaningRobot cleaningRobotSouth = new CleaningRobot(0, 0, Heading.SOUTH);

        cleaningRobotSouth.moveForward();

        assert cleaningRobotSouth.x() == 0;
        assert cleaningRobotSouth.y() == -1;

        CleaningRobot cleaningRobotWest = new CleaningRobot(0, 0, Heading.WEST);

        cleaningRobotWest.moveForward();

        assert cleaningRobotWest.x() == -1;
        assert cleaningRobotWest.y() == 0;
    }

    @Test
    public void shouldRotateLeft() {
        CleaningRobot cleaningRobotNorth = new CleaningRobot(0, 0, Heading.NORTH);

        cleaningRobotNorth.rotateLeft();

        assert cleaningRobotNorth.heading() == Heading.WEST;

        CleaningRobot cleaningRobotEast = new CleaningRobot(0, 0, Heading.EAST);

        cleaningRobotEast.rotateLeft();

        assert cleaningRobotEast.heading() == Heading.NORTH;

        CleaningRobot cleaningRobotSouth = new CleaningRobot(0, 0, Heading.SOUTH);

        cleaningRobotSouth.rotateLeft();

        assert cleaningRobotSouth.heading() == Heading.EAST;

        CleaningRobot cleaningRobotWest = new CleaningRobot(0, 0, Heading.WEST);

        cleaningRobotWest.rotateLeft();

        assert cleaningRobotWest.heading() == Heading.SOUTH;
    }

    @Test
    public void shouldRotateRight() {
        CleaningRobot cleaningRobotNorth = new CleaningRobot(0, 0, Heading.NORTH);

        cleaningRobotNorth.rotateRight();

        assert cleaningRobotNorth.heading() == Heading.EAST;

        CleaningRobot cleaningRobotEast = new CleaningRobot(0, 0, Heading.EAST);

        cleaningRobotEast.rotateRight();

        assert cleaningRobotEast.heading() == Heading.SOUTH;

        CleaningRobot cleaningRobotSouth = new CleaningRobot(0, 0, Heading.SOUTH);

        cleaningRobotSouth.rotateRight();

        assert cleaningRobotSouth.heading() == Heading.WEST;

        CleaningRobot cleaningRobotWest = new CleaningRobot(0, 0, Heading.WEST);

        cleaningRobotWest.rotateRight();

        assert cleaningRobotWest.heading() == Heading.NORTH;
    }
}
