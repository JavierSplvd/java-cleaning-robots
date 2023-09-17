package com.javier.entities;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.javier.enums.Heading;

public class GridTest {
    private Grid grid = new Grid(5, 5);

    @Test
    public void whenWithinBounds_shouldAddRobots() {
        CleaningRobot cleaningRobot1 = new CleaningRobot(1, 1, Heading.N);
        CleaningRobot cleaningRobot2 = new CleaningRobot(2, 1, Heading.N);
        grid.addCleaningRobot(cleaningRobot1);
        grid.addCleaningRobot(cleaningRobot2);

        assertTrue(grid.getCleaningRobots().size() == 2);
        assertTrue(grid.getCleaningRobots().get(0).x() == 1);
        assertTrue(grid.getCleaningRobots().get(0).y() == 1);
        assertTrue(grid.getCleaningRobots().get(1).x() == 2);
        assertTrue(grid.getCleaningRobots().get(1).y() == 1);
    }

    @Test
    public void whenOutOfBounds_shouldThrowException() {
        CleaningRobot cleaningRobot1 = new CleaningRobot(10, 10, Heading.N);
        assertThrows(Exception.class, () -> grid.addCleaningRobot(cleaningRobot1));
    }

    @Test
    public void givenTwoRobots_whenSameCoordinates_shoudlThrowException() {
        CleaningRobot cleaningRobot1 = new CleaningRobot(1, 1, Heading.N);
        CleaningRobot cleaningRobot2 = new CleaningRobot(1, 1, Heading.N);
        grid.addCleaningRobot(cleaningRobot1);
        // check an exception is thrown
        assertThrows(Exception.class, () -> grid.addCleaningRobot(cleaningRobot2));
    }

}
