package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Configuration {
    private final Logger logger = LogManager.getLogger();

    public List<String> getPaths(String[] args) {
        List<String> paths = new ArrayList<>();
        Options optionsI = new Options();
        optionsI.addOption("i", "input", true, "Reading flag type");
        optionsI.addOption("p", true, "Reading user inputted path");
        optionsI.addOption("method", true, "Reading user requested method");
        optionsI.addOption("baseline", true, "Reading user requested baseline");
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(optionsI, args);
            paths.add(cmd.getOptionValue("i", "input"));
            paths.add(formatStr(cmd.getOptionValue("p", "null")));
            paths.add(cmd.getOptionValue("method", "righthand"));
            paths.add(cmd.getOptionValue("baseline", "null"));
        } catch (Exception e) {
            logger.error("An error has occurred");
        }
        return paths;
    }

    // Formats the user inputted path in either Canonical or Factorized form and
    // returns the path in Canonical form
    public String formatStr(String conv) {
        String str = conv.trim().replaceAll("\\s", "");
        String newStr = "";
        if (str.length() == 1) {
            return str;
        }
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i);
            char nextChar = str.charAt(i + 1);

            // If condition checks if the digit in front of character is double digits
            if (Character.isDigit(c) && Character.isDigit(nextChar)) {
                // Retrieving the numerical value of the double digit
                int n = Character.getNumericValue(c + nextChar);
                // Retrieving the character
                char getChar = str.charAt(i + 2);
                // Appending the character getChar, n times to the String newStr
                newStr += Character.toString(getChar).repeat(n);
                // Skipping to the next digit sequence in the String conv
                i += 2;
                // Else if condition checks if the digit in fron of character is a digit
            } else if (Character.isDigit(c)) {
                // Retrieving the numerical value of the digit
                int num = Character.getNumericValue(c);
                char c2 = str.charAt(i + 1);
                // Appending the character getChar, n times to the String newStr
                newStr += Character.toString(c2).repeat(num);
                // Skipping to the next digit sequence in the String conv
                i += 1;
                // Else condition get's executed if there are no digits in front of the
                // character (Ex: R)
            } else {
                // Appending the single character c to the String newStr
                newStr += c;
            }
        }
        // if condition test's an edge case where if the last character in the String
        // conv doesn't have a number before it then execute the condition, this edge
        // case is cause by the iterations of i from the for loop
        if (!Character.isDigit(str.charAt(str.length() - 2))) {
            // Append the last character to the String.
            newStr += str.charAt(str.length() - 1);
        }
        return newStr;
    }
}
