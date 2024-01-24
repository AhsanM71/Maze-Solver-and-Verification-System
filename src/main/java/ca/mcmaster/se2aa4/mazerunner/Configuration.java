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

    // public void print(String[] args) {
    // logger.info("** Start of Maze Runner");
    // Options options = new Options();
    // options = options.addOption("i", "input", true, "Reading flag type");
    // CommandLineParser parser = new DefaultParser();
    // try {
    // CommandLine cmd = parser.parse(options, args);
    // String path = cmd.getOptionValue("i", "input");
    // readMaze(path);
    // } catch (Exception e) {
    // logger.error("/!\\ An error has occured /!\\");
    // }

    // }

    public String getPath(String[] args) {
        String path = "";
        String userPath = "";
        Options optionsI = new Options();
        optionsI = optionsI.addOption("i", "input", true, "Reading flag type");
        optionsI.addOption("p", true, "Reading user inputted path");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(optionsI, args);
            path = cmd.getOptionValue("i", "input");
            userPath = cmd.getOptionValue("p");
        } catch (Exception e) {
            logger.error("An error has occurred");
        }
        return path;
    }

    public String getUserPath(String[] args) {
        String path = "";
        String userPath = "";
        Options options = new Options();
        options.addOption("i", "input", true, "Reading file path");
        options.addOption("p", true, "Reading user inputted path");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            path = cmd.getOptionValue("i", "-1");
            userPath = cmd.getOptionValue("p");
        } catch (ParseException pe) {
            logger.error("An error has occurred");
        }
        if (userPath != null) {
            String ans = formatStr(userPath);
            return ans;
        }
        return userPath;
    }

    private String formatStr(String conv) {
        String str = conv.replaceAll(" ", "");
        String newStr = "";
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            char cN = str.charAt(i + 1);
            if (Character.isDigit(c) && Character.isDigit(cN)) {
                int n = Character.getNumericValue(c + cN);
                char c3 = str.charAt(i + 2);
                newStr += Character.toString(c3).repeat(n);
                i += 2;
            } else if (Character.isDigit(c)) {
                int num = Character.getNumericValue(c);
                char c2 = str.charAt(i + 1);
                newStr += Character.toString(c2).repeat(num);
                i += 1;
            } else {
                newStr += c;
            }
        }
        if (!Character.isDigit(conv.charAt(conv.length() - 2))) {
            newStr += conv.charAt(conv.length() - 1);
        }
        System.out.println(newStr);
        return newStr;
    }

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
