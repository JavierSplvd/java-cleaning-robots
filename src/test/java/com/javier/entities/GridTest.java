package com.javier.entities;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GridTest {
    private Grid grid = new Grid(5, 5);

    @Test
    public void whenWithinBounds_shouldAddRobots() {
        CleaningRobot cleaningRobot1 = new CleaningRobot(1, 1, Heading.NORTH);
        CleaningRobot cleaningRobot2 = new CleaningRobot(2, 1, Heading.NORTH);
        grid.addCleaningRobot(cleaningRobot1);
        grid.addCleaningRobot(cleaningRobot2);
    }

    @Test
    public void whenOutOfBounds_shouldThrowException() {
        CleaningRobot cleaningRobot1 = new CleaningRobot(10, 10, Heading.NORTH);
        assertThrows(Exception.class, () -> grid.addCleaningRobot(cleaningRobot1));
    }

    @Test
    public void givenTwoRobots_whenSameCoordinates_shoudlThrowException() {
        CleaningRobot cleaningRobot1 = new CleaningRobot(1, 1, Heading.NORTH);
        CleaningRobot cleaningRobot2 = new CleaningRobot(1, 1, Heading.NORTH);
        grid.addCleaningRobot(cleaningRobot1);
        // check an exception is thrown
        assertThrows(Exception.class, () -> grid.addCleaningRobot(cleaningRobot2));
    }

}
