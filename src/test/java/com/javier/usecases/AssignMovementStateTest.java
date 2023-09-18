package com.javier.usecases;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

import com.javier.domain.CleaningRobot;
import com.javier.domain.FactoryFloorGrid;

public class AssignMovementStateTest {
    @Test
    public void whenInput_shouldReturnCreateRobotState() {
        FactoryFloorGrid grid = FactoryFloorGrid.of("5 5");
        grid.addCleaningRobot(CleaningRobot.of("1 2 N"));
        State state = new AssignMovementState(grid);
        state = state.input("LMLMLMLMM");

        assumeTrue(state.getGrid().getCleaningRobots().size() == 1);

        assert (state instanceof CreateRobotState);
        assert (state.getGrid().getCleaningRobots().get(0).position().x() == 1);
        assert (state.getGrid().getCleaningRobots().get(0).position().y() == 3);
    }

    @Test
    public void givenTwoRobots_whenInput_shouldMoveTheLastOne() {
        FactoryFloorGrid grid = FactoryFloorGrid.of("5 5");
        grid.addCleaningRobot(CleaningRobot.of("1 2 N"));
        grid.addCleaningRobot(CleaningRobot.of("4 4 N"));
        State state = new AssignMovementState(grid);
        state = state.input("LMLMLMLMM");

        assumeTrue(state.getGrid().getCleaningRobots().size() == 1);

        assert (state instanceof CreateRobotState);
        assert (state.getGrid().getCleaningRobots().get(1).position().x() == 1);
        assert (state.getGrid().getCleaningRobots().get(1).position().y() == 3);
    }

    @Test
    public void givenNoRobots_whenInput_shouldReturnTheSameState() {
        FactoryFloorGrid grid = FactoryFloorGrid.of("5 5");
        State state = new AssignMovementState(grid);
        state = state.input("LMLMLMLMM");

        assert (state instanceof AssignMovementState);
    }
}
