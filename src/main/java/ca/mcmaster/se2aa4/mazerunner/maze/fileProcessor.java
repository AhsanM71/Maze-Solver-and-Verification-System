package ca.mcmaster.se2aa4.mazerunner.maze;

import java.io.IOException;

public interface fileProcessor {
    public int[] mazeDimension() throws IOException;

    public void builder(int row, int col) throws IOException;

    public void renderMaze();

    public char[][] getMaze();
}
