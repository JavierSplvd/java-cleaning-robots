package com.javier.delivery;

import java.util.Scanner;

import com.javier.domain.CleaningRobot;
import com.javier.domain.FactoryFloorGrid;
import com.javier.usecases.CreateGridState;
import com.javier.usecases.State;

public class CliPresenter implements Presenter {
    public void render() {
        Scanner scanner = new Scanner(System.in);
        State state = new CreateGridState();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            state = state.input(input);
        }

        if (state.getGrid() != null) {
            printFormatted(state.getGrid());
        } else {
            System.out.println("No grid created.");
        }
        scanner.close();
    }

    void printFormatted(FactoryFloorGrid grid) {
        System.out.println("Grid size: " + grid.getMaxX() + "x" + grid.getMaxY());

        int i = 0;
        for (CleaningRobot robot : grid.getCleaningRobots()) {
            i++;
            String message = String.format("Robot %s: %s %s %s", i, robot.position().x(), robot.position().y(),
                    robot.heading());
            System.out.println(message);
        }
    }
}
