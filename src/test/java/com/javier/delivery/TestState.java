package com.javier.delivery;

import com.javier.domain.FactoryFloorGrid;
import com.javier.usecases.State;

public class TestState implements State {

    @Override
    public State input(String input) {
        throw new UnsupportedOperationException("Unimplemented method 'input'");
    }

    @Override
    public FactoryFloorGrid getGrid() {
        throw new UnsupportedOperationException("Unimplemented method 'getGrid'");
    }
    
}
