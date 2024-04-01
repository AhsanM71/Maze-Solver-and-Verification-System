package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.character.Position;

public class PositionTest {
    @Test
    public void equalsTest1() {
        Position p1 = new Position(1, 1);
        Position p2 = new Position(1, 1);
        assertTrue(p1.equals(p2));
    }

    @Test
    public void equalsTest2() {
        Position p1 = new Position(1, 1);
        Position p2 = new Position(0, 0);
        assertFalse(p1.equals(p2));
    }

}
