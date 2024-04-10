package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ConfigurationTest {

    @Test
    void getPathsTest1() {
        Configuration config = new Configuration();
        String[] args = { "-i", "./examples/tiny.maz.txt", "-p", "3F", "-method", "BFS", "-baseline", "null" };
        config.getPaths(args);
        assertEquals("./examples/tiny.maz.txt", config.getInput());
        assertEquals("3F", config.getPath());
        assertEquals("BFS", config.getMethod());
        assertEquals("null", config.getBaseline());
    }

    @Test
    void getPathsTest2() {
        Configuration config = new Configuration();
        String[] args = { "-i", "./examples/tiny.maz.txt", "-p", "3F", };
        config.getPaths(args);
        assertEquals("./examples/tiny.maz.txt", config.getInput());
        assertEquals("3F", config.getPath());
        assertEquals("righthand", config.getMethod());
        assertEquals("null", config.getBaseline());

    }
}
