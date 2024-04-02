package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ConfigurationTest {
    @Test
    void formatStrTest() {
        Configuration config = new Configuration();
        String path = "3F 4F 7L F R L R F L";
        assertEquals("FFFFFFFLLLLLLLFRLRFL", config.formatStr(path));
    }

    @Test
    void getPathsTest() {
        Configuration config = new Configuration();
        String[] args = { "-i", "./examples/tiny.maz.txt", "-p", "3F", "-method", "BFS", "baseline", "null" };
        List<String> paths = config.getPaths(args);
        assertEquals("./examples/tiny.maz.txt", paths.get(0));
        assertEquals("FFF", paths.get(1));
        assertEquals("BFS", paths.get(2));

    }
}
