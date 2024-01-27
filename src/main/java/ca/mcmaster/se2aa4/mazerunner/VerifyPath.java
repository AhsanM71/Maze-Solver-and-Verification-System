package ca.mcmaster.se2aa4.mazerunner;

public class VerifyPath {

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
