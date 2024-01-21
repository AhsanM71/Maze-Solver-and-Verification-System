package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Configuration config = new Configuration();

        String path = config.getPath(args);
        String[] userAns = config.getUserPath(args);
        FindPathAlgo algo = new FindPathAlgo();

        if (userAns[1].equals("-1")) {
            // config.print(args);
            Maze maze = new Maze(path);
            String[] ans = algo.mazeSolver(maze);
            if (algo.isPath()) {
                logger.info("**** Computing path");
                System.out.println("Canonical Form: " + ans[0]);
                System.out.println("Factorized Form: " + ans[1]);
            } else {
                logger.info("PATH NOT COMPUTED");
            }

            logger.info("** End of MazeRunner");
        } else {
            Maze maze = new Maze(userAns[0]);
            Boolean flag = algo.verifyGivenPath(maze, userAns[1]);
            System.out.println(flag);
        }

    }
}
