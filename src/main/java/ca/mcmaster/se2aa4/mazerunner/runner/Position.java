package ca.mcmaster.se2aa4.mazerunner.runner;

import java.util.Objects;

public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getXVal() {
        return x;
    }

    public int getYVal() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Position point = (Position) obj;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public boolean equals(Position pos2) {
        return ((this.getXVal() == pos2.getXVal()) && (this.getYVal() == pos2.getYVal()));
    }

}
