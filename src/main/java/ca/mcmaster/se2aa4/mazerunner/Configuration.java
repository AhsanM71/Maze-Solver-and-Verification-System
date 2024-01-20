package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {
    private static final Logger logger = LogManager.getLogger();

    public void print(String[] args) {
        logger.info("** Start of Maze Runner");
        Options options = new Options();
        options = options.addOption("i", "input", true, "Reading flag type");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            String path = cmd.getOptionValue("i", "input");
            readMaze(path);
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }

    }

    public String getPath(String[] args) {
        String path = "";
        Options optionsI = new Options();
        optionsI = optionsI.addOption("i", "input", true, "Reading flag type");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(optionsI, args);
            path = cmd.getOptionValue("i", "input");
        } catch (Exception e) {

        }
        return path;
    }

    public String[] getUserPath(String[] args) {
        String[] argu = new String[2];
        Options options = new Options();
        options.addOption("i", "input", true, "Reading file path");
        options.addOption("p", true, "Reading user inputted path");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            argu[0] = cmd.getOptionValue("i", "-1");
            argu[1] = cmd.getOptionValue("p", "-1");
        } catch (ParseException pe) {
            logger.error("An error has occurred");
        }
        return argu;
    }

    private void readMaze(String path) {
        try {
            logger.info("**** Reading the maze from file " + path);
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                printMaze(line);
            }
        } catch (Exception e) {
            logger.error("/!\\ An error has occured /!\\");
        }
    }

    private void printMaze(String line) {
        for (int idx = 0; idx < line.length(); idx++) {
            if (line.charAt(idx) == '#') {
                System.out.print("WALL ");
            } else if (line.charAt(idx) == ' ') {
                System.out.print("PASS ");
            }
        }
        System.out.print(System.lineSeparator());
    }
}
