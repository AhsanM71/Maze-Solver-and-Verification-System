package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Maze {
    private char[][] maze;
    private static final Logger logger = LogManager.getLogger();

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
            print2DArr(maze);
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    private void loadMaze(String line, int row, char[][] maze) {
        for (int col = 0; col < line.length(); col++) {
            maze[row][col] = line.charAt(col);
        }
    }

    public void print2DArr(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    // This method checks if at a certain row and col does there exist a wall
    public boolean isWall(int row, int col) {
        return false;
    }

    // This method will check if at a certain row or col does there exist a valid
    // path
    public boolean isPathValid(int row, int col) {
        return false;
    }

}
