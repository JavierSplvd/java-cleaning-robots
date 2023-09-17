package com.javier.delivery;

import com.javier.entities.CleaningRobot;
import com.javier.entities.FactoryFloorGrid;

public class Renderer {
    public static void render(FactoryFloorGrid grid) {
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
