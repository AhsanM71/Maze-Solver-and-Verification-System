package ca.mcmaster.se2aa4.mazerunner.algorithms;

import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public interface PathFinder {
    public Path mazeSolver(Maze maze, Path format);
}
