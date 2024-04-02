package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.runner.Position;

public class PositionTest {
    @Test
    void equalsTest1() {
        Position p1 = new Position(1, 1);
        Position p2 = new Position(1, 1);
        assertEquals(p1, p2);
    }

    @Test
    void equalsTest2() {
        Position p1 = new Position(1, 1);
        Position p2 = new Position(0, 0);
        assertNotEquals(p1, p2);
    }

}
