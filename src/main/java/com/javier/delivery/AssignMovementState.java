package com.javier.delivery;

import com.javier.entities.CleaningRobot;
import com.javier.entities.Grid;

public class AssignMovementState implements CliState {
    private final Grid grid;

    public AssignMovementState(Grid grid) {
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
                    if(grid.isPositionValid(robot.x(), robot.y())) {
                        robot.moveForward();
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
    public Grid getGrid() {
        return grid;
    }

}
