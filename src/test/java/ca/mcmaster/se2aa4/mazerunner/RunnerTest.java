package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Direction;
import ca.mcmaster.se2aa4.mazerunner.runner.Runner;

public class RunnerTest {
    @Test
    public void checkForwardTest() {
        Maze maze = new Maze("./examples/tiny.maz.txt");
        Runner runner = new Runner(5, 0, Direction.EAST, 1, 6);
        boolean flag = runner.checkForward(maze);
        assertTrue(flag);

    }
}
