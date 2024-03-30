package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.IOException;

public interface FileProcessor {
    public int[] mazeDimension() throws IOException;

    public void builder() throws IOException;

    public void renderMaze();

    public MazeCell[][] getMaze();
}
