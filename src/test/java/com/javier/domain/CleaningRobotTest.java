package com.javier.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.javier.domain.CleaningRobot;
import com.javier.domain.Heading;
import com.javier.domain.MoveForwardAction;

public class CleaningRobotTest {
    @Test
    public void shouldMoveForward() {
        CleaningRobot cleaningRobotNorth = new CleaningRobot(0, 0, Heading.N);

        cleaningRobotNorth
                .moveForward(new MoveForwardAction(cleaningRobotNorth.position(), cleaningRobotNorth.heading()));

        assert cleaningRobotNorth.position().x() == 0;
        assert cleaningRobotNorth.position().y() == 1;

        CleaningRobot cleaningRobotEast = new CleaningRobot(0, 0, Heading.E);

        cleaningRobotEast.moveForward(
                new MoveForwardAction(cleaningRobotEast.position(), cleaningRobotEast.heading()));

        assert cleaningRobotEast.position().x() == 1;
        assert cleaningRobotEast.position().y() == 0;

        CleaningRobot cleaningRobotSouth = new CleaningRobot(0, 0, Heading.S);

        cleaningRobotSouth.moveForward(
                new MoveForwardAction(cleaningRobotSouth.position(), cleaningRobotSouth.heading()));

        assert cleaningRobotSouth.position().x() == 0;
        assert cleaningRobotSouth.position().y() == -1;

        CleaningRobot cleaningRobotWest = new CleaningRobot(0, 0, Heading.W);

        cleaningRobotWest.moveForward(
                new MoveForwardAction(cleaningRobotWest.position(), cleaningRobotWest.heading()));

        assert cleaningRobotWest.position().x() == -1;
        assert cleaningRobotWest.position().y() == 0;
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

    @Test
    public void givenTextInput_shouldCreateInstance() {
        CleaningRobot cleaningRobot = CleaningRobot.of("1 1 N");

        assert cleaningRobot.position().x() == 1;
        assert cleaningRobot.position().y() == 1;
        assert cleaningRobot.heading() == Heading.N;
    }

    @Test
    public void givenIncorrectTextInput_shouldThrow() {
        assertThrows(Exception.class, () -> CleaningRobot.of("abc"));
    }
}
