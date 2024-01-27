package ca.mcmaster.se2aa4.mazerunner;

public interface Player {
    public boolean checkForward(Maze maze);

    public boolean checkRight(Maze maze);

    public void moveF();

    public void turnRight();

    public void turnLeft();

    public boolean isExitReached();
}
