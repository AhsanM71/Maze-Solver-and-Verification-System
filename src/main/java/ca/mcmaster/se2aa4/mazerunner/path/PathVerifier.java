package ca.mcmaster.se2aa4.mazerunner.path;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public interface PathVerifier {
    public boolean verifyGivenPath(Maze maze, String path);
}
