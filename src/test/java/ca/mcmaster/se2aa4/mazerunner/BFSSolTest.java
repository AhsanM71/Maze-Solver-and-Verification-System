package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.algorithms.BFSSol;
import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public class BFSSolTest {
    @Test
    void mazeSolverTest1() {
        PathFinder bfs = new BFSSol();
        Maze maze = new Maze("./examples/tiny.maz.txt");
        maze.buildMaze();
        Path format = new Path("null");
        Path path = bfs.mazeSolver(maze, format);
        assertEquals("3F L 4F R 3F", path.canonicalToFactorized());
    }

    @Test
    void mazeSolverTest2() {
        PathFinder bfs = new BFSSol();
        Maze maze = new Maze("./examples/giant.maz.txt");
        maze.buildMaze();
        Path format = new Path("null");
        Path path = bfs.mazeSolver(maze, format);
        String correct = "F L 2F R 2F L 6F R 2F L 6F R 2F R 2F L 2F R 2F L 2F R 8F L 4F R 4F L 6F R 2F L 4F R 2F L 2F R 4F L 4F R 2F L 18F R 4F L 4F R 2F L 2F R 2F L 4F R 4F L 2F R 2F L 2F L 2F R 4F L 2F R 4F L 2F R 10F L 6F R 2F L 2F R 6F L 2F R 2F R 4F L 2F R 2F L 14F R 4F L 4F R 2F L 2F R 8F L 10F R 2F L 4F R 2F L 6F R 2F L 4F R 2F L 6F L 2F R 2F L 4F R 5F";
        assertEquals(correct, path.canonicalToFactorized());
    }

    @Test
    void mazeSolverTest3() {
        PathFinder bfs = new BFSSol();
        Maze maze = new Maze("./examples/rectangle.maz.txt");
        maze.buildMaze();
        Path format = new Path("null");
        Path path = bfs.mazeSolver(maze, format);
        String correct = "F L 11F R 2F R 4F L 8F L 2F R 4F L 2F R 10F R 4F L 6F R 2F L 4F R 4F L 10F L 2F R 4F R F L F";
        assertEquals(correct, path.canonicalToFactorized());
    }
}
