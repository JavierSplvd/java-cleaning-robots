package com.javier.delivery;

import com.javier.entities.FactoryFloorGrid;

public interface CliState {
    CliState input(String input);
    FactoryFloorGrid getGrid();
}
