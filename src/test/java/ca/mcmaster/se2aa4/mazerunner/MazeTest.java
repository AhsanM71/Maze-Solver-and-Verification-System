package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Position;

public class MazeTest {
    private Maze maze;

    @BeforeEach
    public void setUp() {
        maze = new Maze("./examples/tiny.maz.txt");
        maze.buildMaze();
    }

    @Test
    public void isPathValidTest() {
        boolean flag = maze.isPathValid(0, 0);
        assertFalse(flag);
    }

    @Test
    public void findStartPosTest() {
        Position start = maze.findStartPos();
        assertEquals(new Position(0, 5), start);
    }

    @Test
    public void findEndPosTest() {
        Position end = maze.findEndPos();
        assertEquals(new Position(6, 1), end);
    }

}
