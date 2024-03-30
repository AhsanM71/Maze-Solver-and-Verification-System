package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mazeBuilder implements fileProcessor {

    private char[][] maze;
    private String fileName;
    private final Logger logger = LogManager.getLogger();

    public mazeBuilder(String fileName, char[][] maze) {
        this.maze = maze;
        this.fileName = fileName;
    }

    public void renderMaze() {
        try {
            int[] dimensions = mazeDimension();
            int columns = dimensions[0];
            int rows = dimensions[1];

            builder(rows, columns);

        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    public int[] mazeDimension() throws IOException {
        int[] size = new int[2];
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        int col = 0;
        int rows = 0;
        while ((line = reader.readLine()) != null) {
            col = line.length();
            rows++;
        }
        size[0] = col;
        size[1] = rows;
        reader.close();
        return size;
    }

    public void builder(int rows, int columns) throws IOException {
        String line;
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        maze = new char[rows][columns];
        int count = 0;
        while ((line = reader.readLine()) != null) {
            loadMaze(line, count, maze);
            count++;
        }
        reader.close();
    }

    private void loadMaze(String line, int row, char[][] maze) {
        for (int col = 0; col < line.length(); col++) {
            maze[row][col] = line.charAt(col);
        }
    }

    public char[][] getMaze() {
        return maze;
    }
}
