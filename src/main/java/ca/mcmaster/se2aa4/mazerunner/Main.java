package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        Configuration config = new Configuration();

        String path = config.getPath(args);
        String userAns = config.getUserPath(args);

        if (userAns == "") {
            Maze maze = new Maze(path);
            // config.print(args);

            FindPathAlgo algo = new FindPathAlgo();
            String ans = algo.findPath(maze);
            if (algo.isPath()) {
                logger.info("**** Computing path");
                System.out.println(ans);
            } else {
                logger.info("PATH NOT COMPUTED");
            }

            logger.info("** End of MazeRunner");
        } else {
            System.out.println(userAns);
        }

    }
}
