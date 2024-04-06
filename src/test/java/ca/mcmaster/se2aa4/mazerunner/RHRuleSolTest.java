package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RHRuleSol;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public class RHRuleSolTest {

    @Test
    public void mazeSolverTest1() {
        PathFinder rhRule = new RHRuleSol();
        Path p = new Path("");
        Maze maze = new Maze("./examples/tiny.maz.txt");
        maze.buildMaze();
        Path path = rhRule.mazeSolver(maze, p);
        assertEquals("5F 2L 2F R 2F R 2F 2L 2F R 2F R 3F ", path.canonicalToFactorized());
    }

    @Test
    public void mazeSolverTest2() {
        PathFinder rhRule = new RHRuleSol();
        Path p = new Path("");
        Maze maze = new Maze("./examples/direct.maz.txt");
        maze.buildMaze();
        Path path = rhRule.mazeSolver(maze, p);
        assertEquals("F R 2F L 3F R F L F R F L 2F ", path.canonicalToFactorized());
    }

}
