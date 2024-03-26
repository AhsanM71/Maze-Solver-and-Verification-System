package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;

public class FindPathRHRule implements PathFinder {
    private String str = "";

    public String mazeSolver(Maze maze) {
        ArrayList<String> path = new ArrayList<>();

        Position start = null;
        Position end = null;

        start = maze.findStartPos();
        end = maze.findEndPos();

        Runner runner = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());

        // WWile loop will stop once runner has reached the end of the maze
        while (!runner.isExitReached()) {
            // If condition checks if runner can move right
            if (runner.checkRight(maze)) {
                // Move the runner right and appending it's movements to the Arraylist path
                runner.turnRight();
                runner.moveF();
                path.add("R");
                path.add("F");
                // Else if condition get's executed if runner can't turn right but can move
                // forward
            } else if (runner.checkForward(maze)) {
                // Move runner forward and append it's movement to the Arraylist path
                runner.moveF();
                path.add("F");
                // Else condition get's executed if runner can't move right or forward
            } else {
                // Turn runner left and append this action to path
                runner.turnLeft();
                path.add("L");
            }
        }
        // Calling convertToString method to convert the Arraylist path to a String
        str = convertToString(str, path);
        // Calling the factroizedForm method to get the path from Canonical form to
        // Factorized form
        String factorized = factorizedForm(path);
        String answer = factorized;
        return answer;
    }

    private String convertToString(String str, ArrayList<String> path) {
        for (int i = 0; i < path.size(); i++) {
            str += path.get(i);
        }
        return str;
    }

    private String factorizedForm(ArrayList<String> path) {
        // Adding null to the list to act as the stopping condition for the for loop and
        // to ensure the String get's formatted correctly
        path.add("null");
        String conv = "";
        int count = 1;
        for (int i = 0; i < path.size() - 1; i++) {
            // Checking if the neighbouring characters are the same
            if (path.get(i).equals(path.get(i + 1))) {
                // count the number of neighbouring characters that are the same
                count++;
                // Else condition get's executed if the neighbouring characters aren't the same
            } else {
                // If condition checks if theres only one occurance of that specific character
                // then only append that char to the factorized form String
                if (count == 1) {
                    conv += path.get(i) + " ";
                    // Else if there are a number of occurances of a specific char then append the
                    // number of occurances with the char to the factorized form String
                } else {
                    conv += count + path.get(i) + " ";
                }
                count = 1;
            }
        }
        return conv;
    }
}
