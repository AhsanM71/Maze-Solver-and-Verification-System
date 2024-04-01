package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Direction;
import ca.mcmaster.se2aa4.mazerunner.runner.Position;
import ca.mcmaster.se2aa4.mazerunner.runner.Runner;

public class RunnerTest {
    @Test
    public void checkForwardTest() {
        Maze maze = new Maze("./examples/tiny.maz.txt");
        Position start = new Position(0, 5);
        Position end = new Position(6, 1);
        Runner runner = new Runner(start, Direction.EAST, end);
        boolean flag = runner.checkForward(maze);
        assertTrue(flag);

    }
}
