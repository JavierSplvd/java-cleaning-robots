package com.javier.usecases;

import com.javier.entities.CleaningRobot;
import com.javier.entities.FactoryFloorGrid;

public class CreateRobotState implements CliState {
    private final FactoryFloorGrid grid;

    public CreateRobotState(FactoryFloorGrid grid) {
        this.grid = grid;
    }

    @Override
    public CliState input(String input) {
        CleaningRobot robot = CleaningRobot.of(input);
        if (grid.isPositionValid(robot.position())) {
            grid.addCleaningRobot(robot);
        } else {
            System.out.println("Invalid position for robot.");
        }
        return new AssignMovementState(grid);
    }

    @Override
    public FactoryFloorGrid getGrid() {
        return grid;
    }

}
