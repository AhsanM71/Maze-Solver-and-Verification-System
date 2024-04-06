package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.factory.AlgorithmFactory;
import ca.mcmaster.se2aa4.mazerunner.factory.SolveFactory;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.verification.PathVerifier;
import ca.mcmaster.se2aa4.mazerunner.verification.VerifyPath;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        AlgorithmFactory solution = new SolveFactory();
        PathVerifier verify = new VerifyPath();
        Configuration config = new Configuration();
        config.getPaths(args);
        String input = config.getInput();
        Maze maze = new Maze(input);
        maze.buildMaze();

        try {
            solution.runMazeSolver(config, maze, verify);
        } catch (Exception e) {
            logger.info("** Starting Maze Runner");
            logger.info("**** Reading the maze from file" + input);
            logger.info("**** Computing path");
            logger.info("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner");

        }
    }
}
