package com.javier.entities;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private int maxX;
    private int maxY;
    private List<CleaningRobot> cleaningRobots;

    public Grid(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.cleaningRobots = new ArrayList<>(maxX * maxY);
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public boolean isPositionValid(int x, int y) {
        boolean outOfBounds = x > maxX || y > maxY;
        if (outOfBounds) {
            return false;
        }
        for (CleaningRobot robot : cleaningRobots) {
            boolean samePosition = robot.x() == x && robot.y() == y;
            if (samePosition) {
                return false;
            }
        }
        return true;
    }

    public void addCleaningRobot(CleaningRobot cleaningRobot) {
        if (!isPositionValid(cleaningRobot.x(), cleaningRobot.y())) {
            throw new IllegalArgumentException("Invalid position");
        }
        cleaningRobots.add(cleaningRobot);
    }

    public List<CleaningRobot> getCleaningRobots() {
        return cleaningRobots;
    }

    public static Grid of(String sizeAsText) {
        String[] size = sizeAsText.split(" ");
        int maxX = Integer.parseInt(size[0]);
        int maxY = Integer.parseInt(size[1]);
        return new Grid(maxX, maxY);
    }
}
