package ca.mcmaster.se2aa4.mazerunner;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class PathFormatterTest {
    @Test
    void factorizedFormTest1() {
        PathFormatter formatter = new PathFormatter();
        String path = "FFFRRRLLLFLFLRFRFFFF";
        assertEquals("3F 3R 3L F L F L R F R 4F", formatter.factorizedForm(formatter.strToList(path)));
    }

    @Test
    void factorizedFormTest2() {
        PathFormatter formatter = new PathFormatter();
        String path = "FFFFFFFFFFFFFFRRRRRRRRRRRRRR";
        assertEquals("14F 14R", formatter.factorizedForm(formatter.strToList(path)));
    }

    @Test
    void strToListTest() {
        PathFormatter formatter = new PathFormatter();
        String path = "FFFRRRLFLFL";
        List<String> correct = new ArrayList<>();
        for (int i = 0; i < path.length(); i++) {
            correct.add(path.charAt(i) + "");
        }
        List<String> newPath = formatter.strToList(path);
        for (int i = 0; i < path.length(); i++) {
            assertEquals(correct.get(i), newPath.get(i));
        }

    }

}
