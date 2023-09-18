package com.javier.usecases;

import com.javier.domain.CleaningRobot;
import com.javier.domain.FactoryFloorGrid;

public class CreateRobotState implements State {
    private final FactoryFloorGrid grid;

    public CreateRobotState(FactoryFloorGrid grid) {
        this.grid = grid;
    }

    @Override
    public State input(String input) {
        CleaningRobot robot = CleaningRobot.of(input);
        if (grid.isPositionValid(robot.position())) {
            grid.addCleaningRobot(robot);
        } else {
            System.out.println("Invalid position for robot.");
            return this;
        }
        return new AssignMovementState(grid);
    }

    @Override
    public FactoryFloorGrid getGrid() {
        return grid;
    }

}
