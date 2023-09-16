# Cleaning Robots Project

This is my solution 

I have used Java 20.

The code is split into

# Requirements

For this project I will use Windows OS and Powershell as the command line interface.

- Windows 10
- Powershell
- openjdk 20.0.1
- Visual Studio Code 1.80.1

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
mvn build
make run
```
You can check the different commands with `make help`.


# Future improvements