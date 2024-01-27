package ca.mcmaster.se2aa4.mazerunner;

public class Runner implements Player {
    // Entry Position
    private int currRow;
    private int currCol;
    // Exit Position
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

    public boolean checkForward(Maze maze) {
        int newRow = currRow + dir.getChangeRow();
        int newCol = currCol + dir.getChangeCol();
        return newRow >= 0 && newRow < maze.getMazeRSize() && newCol >= 0 && newCol < maze.getMazeCSize()
                && maze.isPathValid(newCol, newRow);
    }

    public boolean checkRight(Maze maze) {
        Direction rightTurn = dir.getRightDir();
        int newRow = currRow + rightTurn.getChangeRow();
        int newCol = currCol + rightTurn.getChangeCol();
        return newRow >= 0 && newRow < maze.getMazeRSize() && newCol >= 0 && newCol < maze.getMazeCSize()
                && maze.isPathValid(newCol, newRow);
    }

    public void moveF() {
        currRow += dir.getChangeRow();
        currCol += dir.getChangeCol();
    }

    public void turnRight() {
        dir = dir.getRightDir();
    }

    public void turnLeft() {
        dir = dir.getLeftDir();
    }

    public boolean isExitReached() {
        return currRow == endRow && currCol == endCol;
    }
}
