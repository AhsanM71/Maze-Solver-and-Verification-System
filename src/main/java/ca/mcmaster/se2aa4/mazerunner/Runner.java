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
        this.dir = dir;
    }

    public boolean checkForward(Maze maze) {
        int newRow = row + dir.getChangeRow();
        int newCol = col + dir.getChangeCol();
        return newRow >= 0 && newRow < maze.getMazeRSize() && newCol >= 0 && newCol < maze.getMazeCSize()
                && maze.isPathValid(newCol, newRow);
    }

    // Created this getRow and getCol methods for debugging delete aferwards!!!!!!!
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // add char[][] maze if you want to print the maze nicely!
    public void moveF() {
        row += dir.getChangeRow();
        col += dir.getChangeCol();
        // delete this afer!!!!!
        // maze[row][col] = 'X';
    }

    public boolean checkRight(Maze maze) {
        Direction rightTurn = dir.getRightDir();
        int newRow = row + rightTurn.getChangeRow();
        int newCol = col + rightTurn.getChangeCol();
        return newRow >= 0 && newRow < maze.getMazeRSize() && newCol >= 0 && newCol < maze.getMazeCSize()
                && maze.isPathValid(newCol, newRow);
    }

    public void turnRight() {
        dir = dir.getRightDir();
    }

    public void turnLeft() {
        dir = dir.getLeftDir();
    }

    public boolean isExitReached() {
        return row == endRow && col == endCol;
    }

    // delete these 2 methods later!!!!!!!!!!!!
    public char[][] copyMaze(Maze maze) {
        char[][] temp = maze.getMaze();
        char[][] copy = new char[temp.length][temp[0].length];
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                copy[i][j] = temp[i][j];
            }
        }
        return copy;
    }

    public void printMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
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
