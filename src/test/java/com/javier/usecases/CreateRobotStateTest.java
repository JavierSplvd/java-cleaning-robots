package com.javier.usecases;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.javier.entities.FactoryFloorGrid;
import com.javier.utils.Heading;

public class CreateRobotStateTest {
    @Test
    public void whenInput_shouldReturnAssignMovementState() {
        FactoryFloorGrid grid = FactoryFloorGrid.of("5 5");
        State state = new CreateRobotState(grid);

        state = state.input("2 2 W");

        assert (state instanceof AssignMovementState);
        assert (state.getGrid().getCleaningRobots().size() == 1);
        assert (state.getGrid().getCleaningRobots().get(0).position().x() == 2);
        assert (state.getGrid().getCleaningRobots().get(0).position().y() == 2);
        assert (state.getGrid().getCleaningRobots().get(0).heading().equals(Heading.W));

    }

    @Test
    public void givenWrongInput_shouldThrow() {
        FactoryFloorGrid grid = FactoryFloorGrid.of("5 5");
        State state = new CreateRobotState(grid);

        assertThrows(IllegalArgumentException.class, () -> {
            state.input("abc");
        });
    }
}
