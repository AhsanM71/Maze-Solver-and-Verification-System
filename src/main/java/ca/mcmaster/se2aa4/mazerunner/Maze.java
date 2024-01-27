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
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            int columns = 0;
            int rows = 0;
            while ((line = reader.readLine()) != null) {
                columns = line.length();
                rows++;
            }
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
