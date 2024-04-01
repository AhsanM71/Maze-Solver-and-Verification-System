package ca.mcmaster.se2aa4.mazerunner.maze;

import ca.mcmaster.se2aa4.mazerunner.runner.Position;

public class Maze {
    private MazeCell[][] maze;
    private FileProcessor builder;

    public Maze(String fileName) {
        builder = new MazeBuilder(fileName, maze);
        builder.renderMaze();
        maze = builder.getMaze();
    }

    public boolean isPathValid(int col, int row) {
        return maze[row][col].getType() == CellType.PATH;
    }

    public Position findStartPos() {
        int row = maze.length;
        for (int i = 0; i < row; i++) {

            if (isPathValid(0, i)) {
                return new Position(0, i);
            }
        }
        return null;
    }

    public Position findEndPos() {
        int row = maze.length;
        for (int i = 0; i < row; i++) {
            if (isPathValid(maze[0].length - 1, i)) {
                return new Position(maze[0].length - 1, i);
            }
        }
        return null;
    }

    public int getMazeRSize() {
        return maze.length;
    }

    public int getMazeCSize() {
        return maze[0].length;
    }
}
