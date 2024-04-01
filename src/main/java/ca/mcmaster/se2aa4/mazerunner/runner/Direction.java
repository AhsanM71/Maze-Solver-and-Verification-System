package ca.mcmaster.se2aa4.mazerunner.runner;

// Enumeration representing the possible directions for runner inside maze

public enum Direction {

    NORTH(-1, 0),

    EAST(0, 1),

    SOUTH(1, 0),

    WEST(0, -1);

    private final int changRow;
    private final int changeCol;

    /**
     * Constructor for Direction enum.
     * 
     * @param changeRow Change in row based on the direction.
     * @param changeCol Change in column based on the direction.
     */

    Direction(int changRow, int changeCol) {
        this.changRow = changRow;
        this.changeCol = changeCol;
    }

    // gets the current change in row based on the direction
    public int getChangeRow() {
        return changRow;
    }

    // gets the current change in column based on the direction
    public int getChangeCol() {
        return changeCol;
    }

    // gets the direction of player when it takes a right turn based on current
    // direction
    public Direction getRightDir() {
        if (this == NORTH) {
            return EAST;
        } else if (this == EAST) {
            return SOUTH;
        } else if (this == SOUTH) {
            return WEST;
        } else {
            return NORTH;
        }
    }

    // gets the direction of player when it takes a left turn based on current
    // direction
    public Direction getLeftDir() {
        if (this == NORTH) {
            return WEST;
        } else if (this == EAST) {
            return NORTH;
        } else if (this == SOUTH) {
            return EAST;
        } else {
            return SOUTH;
        }
    }
}
