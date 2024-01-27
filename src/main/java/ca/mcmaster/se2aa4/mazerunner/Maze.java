package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {

    private char[][] maze;
    private final Logger logger = LogManager.getLogger();

    // This method will read the file and store the maze in a 2D matrix
    public Maze(String fileName) {
        try {
            // Reading the maze file once to obtain the number of rows and columns of the
            // maze
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int columns = 0;
            int rows = 0;
            while ((line = reader.readLine()) != null) {
                columns = line.length();
                rows++;
            }
            // Reading the maze file again to load it into a 2D array
            BufferedReader reader2 = new BufferedReader(new FileReader(fileName));
            maze = new char[rows][columns];
            int count = 0;
            while ((line = reader2.readLine()) != null) {
                loadMaze(line, count, maze);
                count++;
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    // This helper function loads the maze into a 2D array, line by line
    private void loadMaze(String line, int row, char[][] maze) {
        for (int col = 0; col < line.length(); col++) {
            maze[row][col] = line.charAt(col);
        }
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
