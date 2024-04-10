package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Position;

public class MazeTest {
    private Maze maze1;
    private Maze maze2;

    @BeforeEach
    public void setUp() {
        maze1 = new Maze("./examples/tiny.maz.txt");
        maze1.buildMaze();
        maze2 = new Maze("./examples/medium.maz.txt");
        maze2.buildMaze();
    }

    @Test
    public void isPathValidTest1() {
        assertFalse(maze1.isPathValid(0, 0));
    }

    @Test
    public void isPathValidTest2() {
        assertTrue(maze2.isPathValid(1, 1));
    }

    @Test
    public void findStartPosTest1() {
        Position start = maze1.findStartPos();
        assertEquals(new Position(0, 5), start);
    }

    @Test
    public void findStartPosTest2() {
        Position start = maze2.findStartPos();
        assertEquals(new Position(0, 23), start);
    }

    @Test
    public void findEndPosTest1() {
        Position end = maze1.findEndPos();
        assertEquals(new Position(6, 1), end);
    }

    @Test
    public void findEndPosTest2() {
        Position end = maze2.findEndPos();
        assertEquals(new Position(30, 27), end);
    }

}
