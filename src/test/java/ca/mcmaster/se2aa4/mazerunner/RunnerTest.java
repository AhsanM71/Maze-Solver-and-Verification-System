package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Direction;
import ca.mcmaster.se2aa4.mazerunner.runner.Position;
import ca.mcmaster.se2aa4.mazerunner.runner.Runner;

public class RunnerTest {
    private Maze maze1;
    private Position start1;
    private Position end1;
    private Runner runner1;

    private Maze maze2;
    private Position start2;
    private Position end2;
    private Runner runner2;

    @BeforeEach
    public void setUp() {
        maze1 = new Maze("./examples/tiny.maz.txt");
        maze1.buildMaze();
        start1 = new Position(0, 5);
        end1 = new Position(6, 1);
        runner1 = new Runner(start1, Direction.EAST, end1);

        maze2 = new Maze("./examples/medium.maz.txt");
        maze2.buildMaze();
        start2 = new Position(0, 23);
        end2 = new Position(30, 27);
        runner2 = new Runner(start2, Direction.EAST, end2);
    }

    @Test
    public void checkForwardTest1() {
        assertTrue(runner1.checkForward(maze1));
    }

    @Test
    public void checkForwardTest2() {
        assertTrue(runner2.checkForward(maze2));
    }

    @Test
    public void checkRightTest1() {
        assertFalse(runner1.checkRight(maze1));
    }

    @Test
    public void checkRightTest2() {
        assertFalse(runner2.checkRight(maze2));
    }

    @Test
    public void moveFTest1() {
        runner1.moveF();
        assertEquals(new Position(1, 5), new Position(runner1.x(), 5));
    }

    @Test
    public void moveFTest2() {
        runner2.moveF();
        assertEquals(new Position(1, 23), new Position(runner2.x(), 23));
    }

    @Test
    public void isExitReachedTest1() {
        assertFalse(runner1.isExitReached());
    }

    @Test
    public void isExitReachedTest2() {
        assertFalse(runner2.isExitReached());
    }
}
