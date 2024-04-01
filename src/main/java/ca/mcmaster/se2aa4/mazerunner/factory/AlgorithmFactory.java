package ca.mcmaster.se2aa4.mazerunner.factory;

import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFormatter;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.path.VerifyPath;

public interface AlgorithmFactory {
    public void runMazeSolver(List<String> paths, Maze maze, PathFormatter format, VerifyPath verify);
}
