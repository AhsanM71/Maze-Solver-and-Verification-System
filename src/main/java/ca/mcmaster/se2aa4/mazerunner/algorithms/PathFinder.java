package ca.mcmaster.se2aa4.mazerunner.algorithms;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public interface PathFinder {
    public String mazeSolver(Maze maze, PathFormatter format);
}
