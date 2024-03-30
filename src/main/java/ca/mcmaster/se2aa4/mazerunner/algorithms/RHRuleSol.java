package ca.mcmaster.se2aa4.mazerunner.algorithms;

import java.util.ArrayList;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.maze_runner.Direction;
import ca.mcmaster.se2aa4.mazerunner.maze_runner.Position;
import ca.mcmaster.se2aa4.mazerunner.maze_runner.Runner;

public class RHRuleSol implements PathFinder {

    public String mazeSolver(Maze maze, PathFormatter format) {
        ArrayList<String> path = new ArrayList<>();

        Position start = null;
        Position end = null;

        start = maze.findStartPos();
        end = maze.findEndPos();

        Runner runner = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());

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
        return format.factorizedForm(path);
    }
}
