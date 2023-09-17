# Cleaning Robots Project

[![codecov](https://codecov.io/gh/JavierSplvd/java-cleaning-robots/graph/badge.svg?token=0JXJYC79OD)](https://codecov.io/gh/JavierSplvd/java-cleaning-robots)

This is my solution for the exercise of the cleaning robots. I have used Java 20 as the programming language and JUnit 5 for the tests.

The code is split into entities and delivery. The entities are the objects that are used in the application, like the robot or the factory. The delivery is the code that is used to run the application, like the input handling.

# Requirements

For this project I will use Windows OS and Powershell as the command line interface.

- Windows 10
- Powershell
- openjdk 20.0.1
- Visual Studio Code 1.82.2

# Technical requirements

- The robot has x, y coordinates and a direction (NORTH, SOUTH, EAST, WEST).
- The workspace is divided on a simple grid. The grid starts at 0,0 on the bottom left corner.
- If there are multiple robots they move sequentially, i.e. the second robot moves only after the first has finished moving.
- The input of the program is the upper-right coordinates of the workspace and the location of the robots. Then another line with the instructions for the robots.
- The input can be L, R or M. L and R turn the robot 90 degrees left or right respectively, without moving from its current spot. M means move forward one grid point, and maintain the same heading.
- The output of the program should be each robot's final coordinates and heading. Like 1, 2 NORTH.

# How to run the project

In order to simplify the execution of the project I have created a makefile with the following commands:

To run the tests:

```
make test
```

To start the application:

```
make build
make run
```

You can check the different commands with `make help`.


# Future improvements

1. The rotation could implement a 2x2 matrix to multiplicate to the Vector2 position. This could enable the robot to rotate in any direction and use a continuous space for the factory floor.
2. Render the whole floor with the empty cells of the grid and the robots with their direction.

