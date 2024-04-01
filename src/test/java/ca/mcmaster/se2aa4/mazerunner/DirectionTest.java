package ca.mcmaster.se2aa4.mazerunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ca.mcmaster.se2aa4.mazerunner.runner.Direction;

public class DirectionTest {
    @Test
    public void getRightDirTest1() {
        Direction dir = Direction.EAST;
        assertEquals(Direction.SOUTH, dir.getRightDir());
    }

    @Test
    public void getRightDirTest2() {
        Direction dir = Direction.NORTH;
        assertEquals(Direction.EAST, dir.getRightDir());
    }

    @Test
    public void getRightDirTest3() {
        Direction dir = Direction.SOUTH;
        assertEquals(Direction.WEST, dir.getRightDir());
    }

    @Test
    public void getRightDirTest4() {
        Direction dir = Direction.WEST;
        assertEquals(Direction.NORTH, dir.getRightDir());
    }

    @Test
    public void getLeftDirTest1() {
        Direction dir = Direction.EAST;
        assertEquals(Direction.NORTH, dir.getLeftDir());
    }

    @Test
    public void getLeftDirTest2() {
        Direction dir = Direction.SOUTH;
        assertEquals(Direction.EAST, dir.getLeftDir());
    }

    @Test
    public void getLeftDirTest3() {
        Direction dir = Direction.WEST;
        assertEquals(Direction.SOUTH, dir.getLeftDir());
    }

    @Test
    public void getLeftDirTest4() {
        Direction dir = Direction.NORTH;
        assertEquals(Direction.WEST, dir.getLeftDir());
    }
}
