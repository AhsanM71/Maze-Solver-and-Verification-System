package ca.mcmaster.se2aa4.mazerunner.factory;

import ca.mcmaster.se2aa4.mazerunner.Configuration;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.verification.PathVerifier;

public interface AlgorithmFactory {
    public void runMazeSolver(Configuration config, Maze maze, PathVerifier verify);
}
