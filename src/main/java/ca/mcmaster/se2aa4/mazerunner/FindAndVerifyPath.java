package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class FindAndVerifyPath {
    private String ans = "";

    public String[] mazeSolver(Maze maze) {
        ArrayList<String> path = new ArrayList<>();

        Position start = null;
        Position end = null;

        start = maze.findStartPos();
        end = maze.findEndPos();

        Runner runner = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());
        // Runner runner = new Runner(end.getYVal(), end.getXVal(), maze,
        // Direction.WEST, start.getYVal(),
        // start.getXVal());
        // char[][] copy = runner.copyMaze(maze);
        // add copy to moveF afterwards if you want to print the maze nicely
        while (!runner.isExitReached()) {
            if (runner.checkRight(maze)) {
                runner.turnRight();
                runner.moveF();
                path.add("R");
                path.add("F");
            } else if (runner.checkForward(maze)) {
                runner.moveF();
                path.add("F");
            } else {
                runner.turnLeft();
                path.add("L");
            }
        }
        // runner.printMaze(copy);
        ans = convertToString(ans, path);
        String factorized = factorizedForm(path);
        String[] answers = { ans, factorized };
        return answers;
    }

    private String convertToString(String ans, ArrayList<String> path) {
        for (int i = 0; i < path.size(); i++) {
            ans += path.get(i);
        }
        return ans;
    }

    private String factorizedForm(ArrayList<String> path) {
        path.add("null");
        String conv = "";
        int count = 1;
        for (int i = 0; i < path.size() - 1; i++) {
            if (path.get(i).equals(path.get(i + 1))) {
                count++;
            } else {
                if (count == 1) {
                    conv += path.get(i) + " ";
                } else {
                    conv += count + path.get(i) + " ";
                }
                count = 1;
            }
        }
        return conv;
    }

    public boolean isPath() {
        return ans.length() > 0;
    }

    public boolean verifyGivenPath(Maze maze, String path) {
        Position start = maze.findStartPos();
        Position end = maze.findEndPos();

        // Entry is on the west side and exist is east side, runner1 is facing east
        Runner runner1 = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());

        // Entry is on the east side and exist is west side, runner1 is facing west
        Runner runner2 = new Runner(end.getYVal(), end.getXVal(), maze, Direction.WEST, start.getYVal(),
                start.getXVal());

        boolean flagWE;
        boolean flagEW;

        flagWE = pathVerifier(path, maze, true, runner1);
        flagEW = pathVerifier(path, maze, true, runner2);
        return flagEW || flagWE;
    }

    public boolean pathVerifier(String path, Maze maze, Boolean flag, Runner runner) {
        path = path.toUpperCase();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'R') {
                runner.turnRight();
                // if (!runner.checkRight(maze)) {
                // flag = false;
                // break;
                // } else {
                // runner.turnRight();
                // runner.moveF();
                // i += 1;
                // }
            } else if (path.charAt(i) == 'F') {
                if (!runner.checkForward(maze)) {
                    flag = false;
                    break;
                } else {
                    runner.moveF();
                }
            } else {
                runner.turnLeft();
            }
        }
        if (runner.isExitReached() && flag) {
            return true;
        }
        return false;
    }
}
