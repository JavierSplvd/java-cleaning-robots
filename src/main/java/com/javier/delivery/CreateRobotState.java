package com.javier.delivery;

import com.javier.entities.CleaningRobot;
import com.javier.entities.Grid;

public class CreateRobotState implements CliState {
    private final Grid grid;

    public CreateRobotState(Grid grid) {
        this.grid = grid;
    }

    @Override
    public CliState input(String input) {
        CleaningRobot robot = CleaningRobot.of(input);
        if (grid.isPositionValid(robot.x(), robot.y())) {
            grid.addCleaningRobot(robot);
        } else {
            System.out.println("Invalid position for robot.");
        }
        return new AssignMovementState(grid);
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

}
