package com.javier.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class FactoryFloorGridTest {
    private FactoryFloorGrid grid = new FactoryFloorGrid(5, 5);

    @Test
    public void whenWithinBounds_shouldAddRobots() {
        CleaningRobot cleaningRobot1 = new CleaningRobot(1, 1, Heading.N);
        CleaningRobot cleaningRobot2 = new CleaningRobot(2, 1, Heading.N);
        grid.addCleaningRobot(cleaningRobot1);
        grid.addCleaningRobot(cleaningRobot2);

        assertTrue(grid.getCleaningRobots().size() == 2);
        assertTrue(grid.getCleaningRobots().get(0).position().x() == 1);
        assertTrue(grid.getCleaningRobots().get(0).position().y() == 1);
        assertTrue(grid.getCleaningRobots().get(1).position().x() == 2);
        assertTrue(grid.getCleaningRobots().get(1).position().y() == 1);
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

    @Test
    public void givenTextInput_shouldCreateInstance() {
        FactoryFloorGrid grid = FactoryFloorGrid.of("5 5");
        assertTrue(grid.getMaxX() == 5);
        assertTrue(grid.getMaxY() == 5);
    }

    @Test
    public void givenWrongInput_shouldThrow() {
        assertThrows(Exception.class, () -> FactoryFloorGrid.of("5"));
    }

}
