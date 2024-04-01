package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.factory.AlgorithmFactory;
import ca.mcmaster.se2aa4.mazerunner.factory.SolveFactory;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.path.PathVerifier;
import ca.mcmaster.se2aa4.mazerunner.path.VerifyPath;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        AlgorithmFactory solution = new SolveFactory();
        PathVerifier verify = new VerifyPath();
        Configuration config = new Configuration();

        List<String> paths = config.getPaths(args);
        String input = paths.get(0);

        Maze maze = new Maze(input);

        try {
            solution.runMazeSolver(paths, maze, verify);
        } catch (Exception e) {
            logger.info("** Starting Maze Runner");
            logger.info("**** Reading the maze from file" + input);
            logger.info("**** Computing path");
            logger.info("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner");

        }
    }
}
