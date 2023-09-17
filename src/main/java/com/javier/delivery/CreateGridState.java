package com.javier.delivery;

import com.javier.entities.FactoryFloorGrid;

public class CreateGridState implements CliState {
    private FactoryFloorGrid grid;

    @Override
    public CliState input(String input) {
        FactoryFloorGrid newGrid = FactoryFloorGrid.of(input);
        grid = newGrid;
        return new CreateRobotState(grid);
    }

    @Override
    public FactoryFloorGrid getGrid() {
        return grid;
    }

}
