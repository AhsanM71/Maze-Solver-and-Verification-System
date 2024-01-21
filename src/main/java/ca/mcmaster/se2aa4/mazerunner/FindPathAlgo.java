package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class FindPathAlgo {
    private String ans = "";

    // This method will return the path of the maze by calling the pathAlgorithm
    // method, but first
    // it will determine the start and end positions of any given maze.

    // Ask if I should determine the start and end position in 2 different methods?
    public String mazeSolver(Maze maze) {
        ArrayList<String> path = new ArrayList<>();

        Position start = null;
        Position end = null;

        start = maze.findStartPos();
        end = maze.findEndPos();

        Runner runner = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());
        char[][] copy = runner.copyMaze(maze);

        while (!runner.isExitReached()) {
            if (runner.checkRight(maze)) {
                runner.turnRight();
                runner.moveF(copy);
                path.add("R");
                path.add("F");
            } else if (runner.checkForward(maze)) {
                runner.moveF(copy);
                path.add("F");
            } else {
                runner.turnLeft();
                path.add("L");
            }
        }
        runner.printMaze(copy);
        ans = convert(ans, path);
        return ans;
    }

    private String convert(String ans, ArrayList<String> path) {
        for (int i = 0; i < path.size(); i++) {
            ans += path.get(i);
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

    public boolean verifyGivenPath(Maze maze, String path) {
        Position start = maze.findStartPos();
        Position end = maze.findEndPos();
        Position curr = start;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'F') {
                if (!maze.isPathValid(start.getXVal(), start.getYVal())) {
                    return false;
                }
                curr = updatePos(curr, curr.getXVal() + 1, curr.getYVal());
            }
        }
        return curr.getXVal() == end.getXVal() && curr.getYVal() == end.getYVal();
    }
}
