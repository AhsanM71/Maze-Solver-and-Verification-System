package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFormatter;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.path.VerifyPath;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        PathFormatter format = new PathFormatter();
        SolveFactory solution = new SolveFactory();
        VerifyPath verify = new VerifyPath();

        Configuration config = new Configuration();
        List<String> paths = config.getPaths(args);
        String input = paths.get(0);

        Maze maze = new Maze(input);

        try {
            solution.runMazeSolver(paths, maze, format, verify);
        } catch (Exception e) {
            logger.info("** Starting Maze Runner");
            logger.info("**** Reading the maze from file" + input);
            logger.info("**** Computing path");
            logger.info("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner");

        }
    }
}
