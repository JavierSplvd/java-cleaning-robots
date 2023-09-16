package com.javier.entities;

import java.util.List;

public class Grid {
    private int maxX;
    private int maxY;
    private List<CleaningRobot> cleaningRobots;

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.cleaningRobots = List.of();
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void addCleaningRobot(CleaningRobot cleaningRobot) {
        boolean outOfBounds = cleaningRobot.x() > maxX || cleaningRobot.y() > maxY;
        if (outOfBounds) {
            throw new RuntimeException("Cannot add robot outside of grid");
        }
        for (CleaningRobot robot : cleaningRobots) {
            boolean samePosition = robot.x() == cleaningRobot.x() && robot.y() == cleaningRobot.y();
            if (samePosition) {
                throw new RuntimeException("Cannot add robot to the same coordinates as another robot");
            }
        }
        cleaningRobots = List.of(cleaningRobot, cleaningRobot);
    }

    public List<CleaningRobot> getCleaningRobots() {
        return cleaningRobots;
    }
}
