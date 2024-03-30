package ca.mcmaster.se2aa4.mazerunner.maze;

public class MazeCell {
    private CellType type;

    public MazeCell(CellType type) {
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }
}
