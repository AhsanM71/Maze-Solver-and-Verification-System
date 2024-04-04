package ca.mcmaster.se2aa4.mazerunner.algorithms;

import java.util.ArrayList;
import java.util.List;

import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Direction;
import ca.mcmaster.se2aa4.mazerunner.runner.Player;
import ca.mcmaster.se2aa4.mazerunner.runner.Position;
import ca.mcmaster.se2aa4.mazerunner.runner.Runner;

public class RHRuleSol implements PathFinder {

    public Path mazeSolver(Maze maze, Path format) {
        List<String> path = new ArrayList<>();

        Position start = null;
        Position end = null;

        start = maze.findStartPos();
        end = maze.findEndPos();

        Player runner = new Runner(start, Direction.EAST, end);

        // WWile loop will stop once runner has reached the end of the maze
        while (!runner.isExitReached()) {
            // If condition checks if runner can move right
            if (runner.checkRight(maze)) {
                // Move the runner right and appending it's movements to the Arraylist path
                runner.turnRight();
                runner.moveF();
                path.add("R");
                path.add("F");
                // Else if condition get's executed if runner can't turn right but can move
                // forward
            } else if (runner.checkForward(maze)) {
                // Move runner forward and append it's movement to the Arraylist path
                runner.moveF();
                path.add("F");
                // Else condition get's executed if runner can't move right or forward
            } else {
                // Turn runner left and append this action to path
                runner.turnLeft();
                path.add("L");
            }
        }
        // Calling the factroizedForm method to get the path from Canonical form to
        // Factorized form
        format.setPath(format.listToStr(path));
        return format;
    }
}
