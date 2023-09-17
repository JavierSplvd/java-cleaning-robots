package com.javier.delivery;

import com.javier.entities.CleaningRobot;
import com.javier.entities.FactoryFloorGrid;
import com.javier.entities.MoveForwardAction;

public class AssignMovementState implements CliState {
    private final FactoryFloorGrid grid;

    public AssignMovementState(FactoryFloorGrid grid) {
        this.grid = grid;
    }

    @Override
    public CliState input(String input) {
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
