package ca.mcmaster.se2aa4.mazerunner;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.algorithms.BFSSol;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RHRuleSol;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.path.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.path.VerifyPath;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Configuration config = new Configuration();
        List<String> paths = config.getPaths(args);
        String input = paths.get(0);
        VerifyPath verify = new VerifyPath();
        Maze maze = new Maze(input);

        PathFinder rightHandRule;
        PathFinder bfs;

        try {
            String path = paths.get(1);
            String method = paths.get(2);
            if (path.equals("null")) {
                if (method.equals("righthand")) {
                    rightHandRule = new RHRuleSol();
                    String solvedPath = rightHandRule.mazeSolver(maze);
                    if (solvedPath.length() > -1) {
                        System.out.println(solvedPath);
                    } else {
                        logger.info("PATH NOT COMPUTED");
                    }
                } else if (method.equals("BFS")) {
                    bfs = new BFSSol();
                    String solvedPath = bfs.mazeSolver(maze);
                    if (solvedPath.length() > -1) {
                        System.out.println(solvedPath);
                    } else {
                        logger.info("PATH NOT COMPUTED");
                    }
                }
            } else {
                Boolean isValid = verify.verifyGivenPath(maze, path);
                if (isValid) {
                    System.out.println("correct path");
                } else {
                    System.out.println("incorrect path");
                }
            }

        } catch (Exception e) {
            logger.info("** Starting Maze Runner");
            logger.info("**** Reading the maze from file" + input);
            logger.info("**** Computing path");
            logger.info("PATH NOT COMPUTED");
            logger.info("** End of MazeRunner");

        }
    }
}
