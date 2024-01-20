package ca.mcmaster.se2aa4.mazerunner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        // Original Code
        // logger.info("** Starting Maze Runner");
        // Options options = new Options();
        // options.addOption("i", "input", true, "Reading flag type");
        // CommandLineParser parser = new DefaultParser();
        // try {
        // CommandLine commad = parser.parse(options, args);
        // path = commad.getOptionValue("i", "input");
        // logger.info("**** Reading the maze from file " + path);
        // BufferedReader reader = new BufferedReader(new FileReader(path));
        // String line;
        // while ((line = reader.readLine()) != null) {
        // for (int idx = 0; idx < line.length(); idx++) {
        // if (line.charAt(idx) == '#') {
        // System.out.print("WALL ");
        // } else if (line.charAt(idx) == ' ') {
        // System.out.print("PASS ");
        // }
        // }
        // System.out.print(System.lineSeparator());
        // }
        // } catch (Exception e) {
        // logger.error("/!\\ An error has occured /!\\");
        // }
        Configuration config = new Configuration();
        String path = config.getPath(args);
        Maze maze = new Maze(path);
        // config.print(args);
        logger.info("**** Computing path");

        logger.info("PATH NOT COMPUTED");
        logger.info("** End of MazeRunner");
    }

    // private void getPath(String[] args) {
    // logger.info("** Start of Maze Runner");
    // Options options = generateOptions("i", "input", true, "Reading flag type");
    // CommandLineParser parser = new DefaultParser();
    // try {
    // CommandLine cmd = parser.parse(options, args);
    // String path = cmd.getOptionValue("i", "input");
    // readMaze(path);
    // } catch (Exception e) {
    // logger.error("/!\\ An error has occured /!\\");
    // }

    // }

    // private Options generateOptions(String opt, String longOpt, boolean hasArgu,
    // String message) {
    // Options options = new Options();
    // options.addOption(opt, longOpt, hasArgu, message);
    // return options;
    // }

    // private void readMaze(String path) {
    // try {
    // logger.info("**** Reading the maze from file " + path);
    // BufferedReader reader = new BufferedReader(new FileReader(path));
    // String line;
    // while ((line = reader.readLine()) != null) {
    // printMaze(line);
    // }
    // } catch (Exception e) {
    // logger.error("/!\\ An error has occured /!\\");
    // }
    // }

    // private void printMaze(String line) {
    // for (int idx = 0; idx < line.length(); idx++) {
    // if (line.charAt(idx) == '#') {
    // System.out.print("WALL ");
    // } else if (line.charAt(idx) == ' ') {
    // System.out.print("PASS ");
    // }
    // }
    // System.out.print(System.lineSeparator());
    // }
}
