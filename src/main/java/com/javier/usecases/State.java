package com.javier.usecases;

import com.javier.entities.FactoryFloorGrid;

public interface State {
    State input(String input);
    FactoryFloorGrid getGrid();
}
