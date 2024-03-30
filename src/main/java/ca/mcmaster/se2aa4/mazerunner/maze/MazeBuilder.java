package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MazeBuilder implements FileProcessor {
    private MazeCell[][] maze;
    private String fileName;
    private int[] dimensions;
    private BufferedReader reader;
    private final Logger logger = LogManager.getLogger();

    public MazeBuilder(String fileName, MazeCell[][] maze) {
        this.maze = maze;
        this.fileName = fileName;
    }

    public void renderMaze() {
        try {
            dimensions = mazeDimension();
            maze = new MazeCell[dimensions[0]][dimensions[1]];
            initialize();
            builder();
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    public int[] mazeDimension() throws IOException {
        int[] size = new int[2];
        reader = new BufferedReader(new FileReader(fileName));
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

    public void builder() throws IOException {
        String line;
        reader = new BufferedReader(new FileReader(fileName));
        int count = 0;
        while ((line = reader.readLine()) != null) {
            loadMaze(line, count, maze);
            count++;
        }
        reader.close();
    }

    private void loadMaze(String line, int row, MazeCell[][] maze) {
        for (int col = 0; col < line.length(); col++) {
            if (line.charAt(col) == '#') {
                maze[row][col].setType(CellType.WALL);
            }

        }
    }

    public MazeCell[][] getMaze() {
        return maze;
    }

    private void initialize() {
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                maze[i][j] = new MazeCell(CellType.PATH);
            }
        }
    }
}
