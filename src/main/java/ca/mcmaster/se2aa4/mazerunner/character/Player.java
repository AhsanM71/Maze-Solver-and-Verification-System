package ca.mcmaster.se2aa4.mazerunner.character;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public interface Player {
    public boolean checkForward(Maze maze);

    public boolean checkRight(Maze maze);

    public void moveF();

    public void turnRight();

    public void turnLeft();

    public boolean isExitReached();

    public int x();

    public int y();

    public Direction getDir();
}
