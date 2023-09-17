package com.javier.delivery;

import com.javier.entities.CleaningRobot;
import com.javier.entities.Grid;

public class Renderer {
    public static void render(Grid grid) {
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
