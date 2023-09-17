package com.javier.usecases;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CreateGridStateTest {
    @Test
    public void whenInput_shouldReturnCreateRobotState() {
        State state = new CreateGridState();
        state = state.input("5 5");

        assert (state instanceof CreateRobotState);
        assert (state.getGrid().getMaxX() == 5);
        assert (state.getGrid().getMaxY() == 5);
    }

    @Test
    public void givenWrongInput_shouldThrow() {
        State state = new CreateGridState();

        assertThrows(IllegalArgumentException.class, () -> {
            state.input("abc");
        });
    }
}
