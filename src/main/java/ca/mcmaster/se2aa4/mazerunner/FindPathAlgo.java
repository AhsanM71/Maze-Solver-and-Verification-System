package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class FindPathAlgo {
    private String ans = "";

    public String[] mazeSolver(Maze maze) {
        ArrayList<String> path = new ArrayList<>();

        Position start = null;
        Position end = null;

        start = maze.findStartPos();
        end = maze.findEndPos();

        Runner runner = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());
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
        ans = convert(ans, path);
        String factorized = factorizedForm(path);
        String[] answers = { ans, factorized };
        return answers;
    }

    private String convert(String ans, ArrayList<String> path) {
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

        // System.out.println("End Row: " + end.getYVal() + " End col: " +
        // end.getXVal());

        // Entery is on the west side and exist is east side, runner1 is facing east
        Runner runner1 = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());

        // Entery is on the east side and exist is west side, runner1 is facing west
        Runner runner2 = new Runner(end.getYVal(), end.getXVal(), maze, Direction.WEST, start.getYVal(),
                start.getXVal());

        boolean flagWE = true;
        boolean flagEW = true;
        path += "F";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'R') {
                if (!runner1.checkRight(maze)) {
                    flagWE = false;
                    break;
                } else {
                    runner1.turnRight();
                    runner1.moveF();
                    // System.out.println("curr Row: " + runner1.getRow() + " curr col: " +
                    // runner1.getCol());
                    i += 1;
                }
            } else if (path.charAt(i) == 'F') {
                if (!runner1.checkForward(maze)) {
                    flagWE = false;
                    break;
                } else {
                    runner1.moveF();
                    // System.out.println("curr Row: " + runner1.getRow() + " curr col: " +
                    // runner1.getCol());
                }
            } else {
                runner1.turnLeft();
            }
        }

        if (runner1.isExitReached() && flagWE) {
            return true;
        }

        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'R') {
                if (!runner2.checkRight(maze)) {
                    flagEW = false;
                    break;
                } else {
                    runner2.turnRight();
                    runner2.moveF();
                    i += 1;
                }
            } else if (path.charAt(i) == 'F') {
                if (!runner2.checkForward(maze)) {
                    flagEW = false;
                    break;
                } else {
                    runner2.moveF();
                }
            } else {
                runner2.turnLeft();
            }
        }
        if (runner1.isExitReached() && flagEW) {
            return true;
        }
        return false;
    }
}
