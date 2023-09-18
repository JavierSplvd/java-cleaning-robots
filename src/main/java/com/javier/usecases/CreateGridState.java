package com.javier.usecases;

import com.javier.domain.FactoryFloorGrid;

public class CreateGridState implements State {
    private FactoryFloorGrid grid;

    @Override
    public State input(String input) {
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
