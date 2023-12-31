package com.javier.usecases;

import com.javier.domain.CleaningRobot;
import com.javier.domain.FactoryFloorGrid;
import com.javier.domain.MoveForwardAction;

public class AssignMovementState implements State {
    private final FactoryFloorGrid grid;

    public AssignMovementState(FactoryFloorGrid grid) {
        this.grid = grid;
    }

    @Override
    public State input(String input) {
        if(grid.getCleaningRobots().isEmpty()) {
            System.out.println("No robots to move.");
            return this;
        }
        CleaningRobot robot = grid.getCleaningRobots().get(grid.getCleaningRobots().size() - 1);
        for (char c : input.toCharArray()) {
            switch (c) {
                case 'L':
                    robot.rotateLeft();
                    break;
                case 'R':
                    robot.rotateRight();
                    break;
                case 'M':
                    MoveForwardAction action = new MoveForwardAction(robot.position(), robot.heading());
                    if (grid.isPositionValid(action.getNewPosition())) {
                        robot.moveForward(action);
                    }
                    break;
                default:
                    System.out.println(String.format("Invalid movement command %s.", c));
                    break;
            }
        }
        return new CreateRobotState(grid);
    }

    @Override
    public FactoryFloorGrid getGrid() {
        return grid;
    }

}
