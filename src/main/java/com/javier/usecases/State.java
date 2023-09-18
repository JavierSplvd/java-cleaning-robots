package com.javier.usecases;

import com.javier.domain.FactoryFloorGrid;

public interface State {
    State input(String input);
    FactoryFloorGrid getGrid();
}
