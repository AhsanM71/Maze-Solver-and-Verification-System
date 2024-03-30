package ca.mcmaster.se2aa4.mazerunner.maze;

import ca.mcmaster.se2aa4.mazerunner.maze_runner.Position;

public class Maze {

    private char[][] maze;
    private fileProcessor builder;

    // This method will read the file and store the maze in a 2D matrix
    public Maze(String fileName) {
        builder = new mazeBuilder(fileName, maze);
        builder.renderMaze();
        maze = builder.getMaze();
    }

    // This method will check if at a certain row or col does there exist a valid
    // path
    public boolean isPathValid(int col, int row) {
        return maze[row][col] == ' ';
    }

    // This method get's the start position of the maze
    public Position findStartPos() {
        int row = maze.length;
        for (int i = 0; i < row; i++) {
            // Looking for the only valid path for the first column of the maze (a.k.a start
            // position)
            if (isPathValid(0, i)) {
                return new Position(0, i);
            }
        }
        return null;
    }

    // This method get's the end position of the maze
    public Position findEndPos() {
        int row = maze.length;
        for (int i = 0; i < row; i++) {
            // Looking for the only valid path for the last column of the maze (a.k.a end
            // position)
            if (isPathValid(maze[0].length - 1, i)) {
                return new Position(maze[0].length - 1, i);
            }
        }
        return null;
    }

    // Returns the dimensions of the maze
    public int getMazeRSize() {
        return maze.length;
    }

    public int getMazeCSize() {
        return maze[0].length;
    }
}
