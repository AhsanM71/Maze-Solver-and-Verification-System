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

    private Options options;

    public Configuration() {
        options = new Options();
        options.addOption("i", "input", true, "Reading flag type");
        options.addOption("p", "path", true, "Reading user inputted path");
        options.addOption("m", "method", true, "Reading user requested method");
        options.addOption("b", "baseline", true, "Reading user requested baseline");
    }

    public List<String> getPaths(String[] args) {
        List<String> paths = new ArrayList<>();
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
            paths.add(getOptionValue(cmd, OptionType.INPUT));
            paths.add(getOptionValue(cmd, OptionType.PATH));
            paths.add(getOptionValue(cmd, OptionType.METHOD));
            paths.add(getOptionValue(cmd, OptionType.BASELINE));
        } catch (Exception e) {
            logger.error("An error has occurred");
        }
        return paths;
    }

    private String getOptionValue(CommandLine cmd, OptionType optionType) {
        String defaultValue = optionType.getDefaultValue();
        String optionValue = cmd.getOptionValue(optionType.getShortName(), defaultValue);
        return optionValue != null ? optionValue : defaultValue;
    }

    private enum OptionType {
        INPUT("i", "input", "null"),
        PATH("p", "path", "null"),
        METHOD("m", "method", "righthand"),
        BASELINE("b", "baseline", "null");

        private final String shortName;
        private final String longName;
        private final String defaultValue;

        OptionType(String shortName, String longName, String defaultValue) {
            this.shortName = shortName;
            this.longName = longName;
            this.defaultValue = defaultValue;
        }

        public String getShortName() {
            return shortName;
        }

        public String getLongName() {
            return longName;
        }

        public String getDefaultValue() {
            return defaultValue;
        }
    }
}
