package ca.mcmaster.se2aa4.mazerunner.maze_runner;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public class Runner implements Player {
    // Current Position of Runner
    private int currRow;
    private int currCol;
    // End Position of the maze
    private int endRow;
    private int endCol;
    private Direction dir;

    public Runner(int currRow, int currCol, Maze maze, Direction dir, int endRow, int endCol) {
        this.currRow = currRow;
        this.currCol = currCol;
        this.endRow = endRow;
        this.endCol = endCol;
        this.dir = dir;
    }

    // Method checks if runner can move forward
    public boolean checkForward(Maze maze) {
        // Obtaining the new row and column positions of the runner after moving forward
        // based on the direction its facing
        int newRow = currRow + dir.getChangeRow();
        int newCol = currCol + dir.getChangeCol();
        // Checking if the new position is within the maze and if there is a valid path
        return newRow >= 0 && newRow < maze.getMazeRSize() && newCol >= 0 && newCol < maze.getMazeCSize()
                && maze.isPathValid(newCol, newRow);
    }

    // Method checks if runner can turn right
    public boolean checkRight(Maze maze) {
        // Get the right turn direction based on previous direction the runner was
        // facing
        Direction rightTurn = dir.getRightDir();
        // Obtaining the new row and column positions of the runner after making the
        // right turn and moving forward based on the direction its facing
        int newRow = currRow + rightTurn.getChangeRow();
        int newCol = currCol + rightTurn.getChangeCol();
        // Checking if the new position is within the maze and if there is a valid path
        return newRow >= 0 && newRow < maze.getMazeRSize() && newCol >= 0 && newCol < maze.getMazeCSize()
                && maze.isPathValid(newCol, newRow);
    }

    // Moving the runner forward by updating it's current row and column positions
    public void moveF() {
        currRow += dir.getChangeRow();
        currCol += dir.getChangeCol();
    }

    // Turning the runner right by updating its current direction after the right
    // turn has been made
    public void turnRight() {
        dir = dir.getRightDir();
    }

    // Turning the runner left by updating its current direction after the left turn
    // has been made
    public void turnLeft() {
        dir = dir.getLeftDir();
    }

    // Checking if runner has reached the exit
    public boolean isExitReached() {
        return currRow == endRow && currCol == endCol;
    }

    public int x() {
        return dir.getChangeCol();
    }

    public int y() {
        return dir.getChangeRow();
    }

    public Direction getDir() {
        return dir;
    }
}
