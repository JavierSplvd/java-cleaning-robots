package com.javier.usecases;

import com.javier.entities.FactoryFloorGrid;

public class CreateGridState implements CliState {
    private FactoryFloorGrid grid;

    @Override
    public CliState input(String input) {
        try {
            FactoryFloorGrid newGrid = FactoryFloorGrid.of(input);
            grid = newGrid;
            return new CreateRobotState(grid);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input.");
        }
    }

    @Override
    public FactoryFloorGrid getGrid() {
        return grid;
    }

}
