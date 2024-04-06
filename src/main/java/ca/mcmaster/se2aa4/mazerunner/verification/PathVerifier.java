package ca.mcmaster.se2aa4.mazerunner.verification;

import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public interface PathVerifier {
    public boolean verifyGivenPath(Maze maze, Path p);
}
