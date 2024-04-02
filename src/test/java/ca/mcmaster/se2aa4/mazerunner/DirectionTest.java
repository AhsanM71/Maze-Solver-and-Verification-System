package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.runner.Direction;

public class DirectionTest {
    @Test
    void getRightDirTest1() {
        Direction dir = Direction.EAST;
        assertEquals(Direction.SOUTH, dir.getRightDir());
    }

    @Test
    void getRightDirTest2() {
        Direction dir = Direction.NORTH;
        assertEquals(Direction.EAST, dir.getRightDir());
    }

    @Test
    void getRightDirTest3() {
        Direction dir = Direction.SOUTH;
        assertEquals(Direction.WEST, dir.getRightDir());
    }

    @Test
    void getRightDirTest4() {
        Direction dir = Direction.WEST;
        assertEquals(Direction.NORTH, dir.getRightDir());
    }

    @Test
    void getLeftDirTest1() {
        Direction dir = Direction.EAST;
        assertEquals(Direction.NORTH, dir.getLeftDir());
    }

    @Test
    void getLeftDirTest2() {
        Direction dir = Direction.SOUTH;
        assertEquals(Direction.EAST, dir.getLeftDir());
    }

    @Test
    void getLeftDirTest3() {
        Direction dir = Direction.WEST;
        assertEquals(Direction.SOUTH, dir.getLeftDir());
    }

    @Test
    void getLeftDirTest4() {
        Direction dir = Direction.NORTH;
        assertEquals(Direction.WEST, dir.getLeftDir());
    }
}
