package com.javier.delivery;

import java.util.Scanner;

import com.javier.domain.CleaningRobot;
import com.javier.domain.FactoryFloorGrid;
import com.javier.usecases.State;

public class CliPresenter implements Presenter {
    private State state;
    private final Scanner scanner;

    public CliPresenter(Scanner scanner, State state) {
        this.scanner = scanner;
        this.state = state;
    }

    public void render() {

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
            throw new RuntimeException("No grid found");
        }
    }

    void printFormatted(FactoryFloorGrid grid) {
        System.out.println(grid.getMaxX() + " " + grid.getMaxY());

        for (CleaningRobot robot : grid.getCleaningRobots()) {
            String message = String.format("%s %s %s", robot.position().x(), robot.position().y(),
                    robot.heading());
            System.out.println(message);
        }
    }
}
