package ca.mcmaster.se2aa4.mazerunner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Configuration config = new Configuration();
        String path = config.getPath(args);
        String userPath = config.getUserPath(args);

        VerifyPath verify = new VerifyPath();
        Maze maze = new Maze(path);

        PathFinder rightHandRule;
        // if Condition checking if a user inputted path is given from the command line.
        if (userPath == null) {
            // if block get's executed since only the maze file path was written in the
            // command line
            // Using the rightHandRule algoirthm to solve the maze
            logger.info("** Starting Maze Runner");
            logger.info("**** Computing path");
            try {
                rightHandRule = new FindPathRHRule();
                String solvedPath = rightHandRule.mazeSolver(maze);
                if (solvedPath.length() > -1) {
                    // logger.info("**** Computing path");
                    System.out.println("Factorized Form: " + solvedPath);
                } else {
                    logger.info("PATH NOT COMPUTED");
                }
            } catch (Exception e) {
                logger.info("PATH NOT COMPUTED");
            }

        } else {
            // else block get's executed since user inputted the maze file path and maze
            // solution to verify
            Boolean isValid = verify.verifyGivenPath(maze, userPath);
            if (isValid) {
                System.out.println("correct path");
            } else {
                System.out.println("incorrect path");
            }
        }
        logger.info("** End of MazeRunner");
    }
}
