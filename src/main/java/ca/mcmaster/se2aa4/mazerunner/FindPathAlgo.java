package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class FindPathAlgo {
    private String ans = "";

    // This method will return the path of the maze by calling the pathAlgorithm
    // method, but first
    // it will determine the start and end positions of any given maze.

    // Ask if I should determine the start and end position in 2 different methods?
    public String findPath() {

        return null;
    }

    // This method will return the path of the maze, it has the parameters of maze,
    // start position and end position
    public String pathAlgoirthm(Maze maze, Position start, Position end) {
        Position curr = start;
        ArrayList<String> dir = new ArrayList<>();

        while (curr.getXVal() != end.getXVal() || curr.getYVal() != end.getYVal()) {
            int x = curr.getXVal();
            int y = curr.getYVal();

            // Turn right
            if (maze.isPathValid(x, y + 1)) {
                dir.add("R");
                // is there a valid path for the front
                if (maze.isPathValid(x, y + 1)) {
                    curr = updatePos(curr, x, y + 1);
                    dir.add("F");
                }
            }
            // is there a valid path for the front
            else if (maze.isPathValid(x + 1, y)) {
                curr = updatePos(curr, x + 1, y);
                dir.add("F");
            } else {
                break;
            }
        }

        for (int i = 0; i < dir.size(); i++) {
            ans += dir.get(i);
        }

        return ans;
    }

    public boolean isPath() {
        return ans.length() > 0;
    }

    // This method will move my current object to a desired position, this is a
    // helper function for pathAlgoirthm
    private Position updatePos(Position curr, int x, int y) {
        curr.setX(x);
        curr.setY(y);
        return curr;
    }

    public boolean verifyGivenPath(String path) {
        return false;
    }
}
