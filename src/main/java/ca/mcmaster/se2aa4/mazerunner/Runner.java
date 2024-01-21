package ca.mcmaster.se2aa4.mazerunner;

public class Runner {
    private int row;
    private int col;
    private int endRow;
    private int endCol;
    private Direction dir;

    public Runner(int row, int col, Maze maze, Direction dir, int endRow, int endCol) {
        this.row = row;
        this.col = col;
        this.endRow = endRow;
        this.endCol = endCol;
    }

    public boolean checkForward(Maze maze) {
        int newRow = row + dir.getChangeRow();
        int newCol = col + dir.getChangeCol();
        return newRow >= 0 && newRow <= 10 && newCol >= 0 && newCol <= 10 && maze.isPathValid(newCol, newRow);
    }

    public void moveF() {
        row += dir.getChangeRow();
        col += dir.getChangeCol();
    }

    public boolean checkRight(Maze maze) {
        Direction rightTurn = dir.getRightDir();
        int newRow = row + rightTurn.getChangeRow();
        int newCol = col + rightTurn.getChangeCol();
        return newRow >= 0 && newRow <= 10 && newCol >= 0 && newCol <= 10 && maze.isPathValid(newCol, newRow);
    }

    public void turnRight() {
        dir = dir.getRightDir();
    }

    public void turnLeft() {
        dir = dir.getLeftDir();
    }
}

enum Direction {

    NORTH(-1, 0),

    EAST(0, 1),

    SOUTH(1, 0),

    WEST(0, -1);

    private final int changRow;
    private final int changeCol;

    Direction(int changRow, int changeCol) {
        this.changRow = changRow;
        this.changeCol = changeCol;
    }

    public int getChangeRow() {
        return changRow;
    }

    public int getChangeCol() {
        return changeCol;
    }

    public Direction getRightDir() {
        if (this == NORTH) {
            return EAST;
        } else if (this == EAST) {
            return SOUTH;
        } else if (this == SOUTH) {
            return WEST;
        } else {
            return NORTH;
        }
    }

    public Direction getLeftDir() {
        if (this == NORTH) {
            return WEST;
        } else if (this == EAST) {
            return NORTH;
        } else if (this == SOUTH) {
            return EAST;
        } else {
            return SOUTH;
        }
    }
}
