package ca.mcmaster.se2aa4.mazerunner.verification;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Direction;
import ca.mcmaster.se2aa4.mazerunner.runner.Player;
import ca.mcmaster.se2aa4.mazerunner.runner.Position;
import ca.mcmaster.se2aa4.mazerunner.runner.Runner;

public class VerifyPath implements PathVerifier {
    private final Logger logger = LogManager.getLogger();

    // Method tha verifies a user inputted path as a correct or incorrect solution
    // of the maze
    public boolean verifyGivenPath(Maze maze, Path p) {
        // Obtaining the start and end positions of the maze
        Position start = maze.findStartPos();
        Position end = maze.findEndPos();

        // Checking the path from EAST to WEST and WEST to EAST:
        // Entry is on the west side and exist is east side, runner1 is facing east
        Player runner1 = new Runner(start, Direction.EAST, end);

        // Entry is on the east side and exist is west side, runner1 is facing west
        Player runner2 = new Runner(end, Direction.WEST, start);

        boolean flagWE;
        boolean flagEW;
        flagWE = pathVerifier(p, maze, true, runner1);
        flagEW = pathVerifier(p, maze, true, runner2);

        // Return true if the user inputted path is valid from the direction EAST to
        // WEST or WEST to EAST
        return flagEW || flagWE;
    }

    // This helper function actually checks the user inputted path
    private boolean pathVerifier(Path p, Maze maze, Boolean isValid, Player runner) {
        String path = p.factorizedToCanonical().toUpperCase();
        boolean flag = true;
        for (int i = 0; i < path.length(); i++) {
            try {
                // This helper method checks if the user inputted String contains any invalid
                // inputs, such as a char that's no L or R or F
                checker(path.charAt(i));
                if (path.charAt(i) == 'R') {
                    runner.turnRight();
                    // If the ith char is F check if runner can move forward
                } else if (path.charAt(i) == 'F') {
                    // If runner can't move forward then set isValid to false and break outside of
                    // loop
                    if (!runner.checkForward(maze)) {
                        isValid = false;
                        break;
                        // If the runner can move forward then move forward
                    } else {
                        runner.moveF();
                    }
                    // If the ith char is L then runner turns left
                } else {
                    runner.turnLeft();
                }
            } catch (IllegalArgumentException e) {
                flag = false;
                logger.error(e);
            }
        }
        // After all the movements are performed from the path, check if runner has
        // reached the end and return true if it has
        if (runner.isExitReached() && isValid) {
            return flag;
        }
        return false;
    }

    private void checker(char c) {
        if (!(c == 'R' || c == 'L' || c == 'F')) {
            throw new IllegalArgumentException(
                    "Inputted path contains an invalid char (runner can only move F, L, or R)");
        }
    }
}
