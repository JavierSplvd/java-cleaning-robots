package com.javier.delivery;

import com.javier.entities.Grid;

public class CreateGridState implements CliState {
    private Grid grid;

    @Override
    public CliState input(String input) {
        Grid newGrid = Grid.of(input);
        grid = newGrid;
        return new CreateRobotState(grid);
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

}
