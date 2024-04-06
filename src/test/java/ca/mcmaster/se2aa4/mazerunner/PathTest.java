package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class PathTest {
    @Test
    void canonicalToFactorizedTest() {
        Path path = new Path("FFFRRRLLLFLFLRFRFFFF");
        assertEquals("3F 3R 3L F L F L R F R 4F ", path.canonicalToFactorized());
    }

    @Test
    void factorizedToCanonicalTest() {
        Path path = new Path("14F 14R");
        assertEquals("FFFFFFFFFFFFFFRRRRRRRRRRRRRR", path.factorizedToCanonical());
    }

    @Test
    void strToListTest() {
        Path p = new Path("FFFRRRLFLFL");
        List<String> correct = new ArrayList<>();
        String path = p.getPath();
        for (int i = 0; i < path.length(); i++) {
            correct.add(path.charAt(i) + "");
        }
        List<String> newPath = p.strToList(path);
        for (int i = 0; i < path.length(); i++) {
            assertEquals(correct.get(i), newPath.get(i));
        }
    }

}
