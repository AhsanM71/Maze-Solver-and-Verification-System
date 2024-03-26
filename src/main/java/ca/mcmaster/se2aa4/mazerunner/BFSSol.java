package ca.mcmaster.se2aa4.mazerunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BFSSol implements PathFinder {

    public String mazeSolver(Maze maze) {
        int cols = maze.getMazeCSize();
        int rows = maze.getMazeRSize();
        Set<Position> visited = new HashSet<>();
        Map<Position, Position> path = new HashMap<>();
        Queue<Position> queue = new LinkedList<>();
        Position start = maze.findStartPos();
        Position end = maze.findEndPos();
        Player runner = new Runner(start.getYVal(), start.getXVal(), maze, Direction.EAST, end.getYVal(),
                end.getXVal());
        Direction prevDir = runner.getDir();
        queue.add(start);
        visited.add(start);
        while (!(queue.isEmpty())) {
            Position curr = queue.poll();
            if (curr.equals(end)) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int newX = curr.getXVal() + runner.x();
                int newY = curr.getYVal() + runner.y();
                runner.turnRight();
                Position neighbour = new Position(newX, newY);
                if (isValid(newX, newY, rows, cols, neighbour, maze, visited)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                    path.put(neighbour, curr);
                }
            }
        }
        List<Position> shortestPath = new ArrayList<>();
        Position current = end;
        while (current != null) {
            shortestPath.add(current);
            current = path.get(current);
        }
        Collections.reverse(shortestPath);
        return sp(shortestPath, prevDir);
    }

    public boolean isValid(int newX, int newY, int rows, int cols, Position neighbour, Maze maze,
            Set<Position> visited) {
        return newX >= 0 && newX < cols && newY >= 0 && newY < rows && maze.isPathValid(newX, newY)
                && !visited.contains(neighbour);
    }

    public String sp(List<Position> path, Direction prevDir) {
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < path.size(); i++) {
            Position prev = path.get(i - 1);
            Position curr = path.get(i);
            int dx = curr.getXVal() - prev.getXVal();
            int dy = curr.getYVal() - prev.getYVal();

            if (dx == 1 && dy == 0) {
                sb.append("E");
            } else if (dx == -1 && dy == 0) {
                sb.append("W");
            } else if (dx == 0 && dy == 1) {
                sb.append("S");
            } else if (dx == 0 && dy == -1) {
                sb.append("N");
            }

        }

        if (prevDir == Direction.EAST) {
            c = 'E';
        } else if (prevDir == Direction.NORTH) {
            c = 'N';
        } else if (prevDir == Direction.WEST) {
            c = 'W';
        } else {
            c = 'S';
        }
        return converter(sb.toString(), c);
    }

    public String converter(String str, char prevDir) {
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);
            if (dir == prevDir) {
                sp.append("F");
            } else {
                if (dir == getLeft(prevDir)) {
                    sp.append("LF");
                    prevDir = dir;
                } else {
                    sp.append("RF");
                    prevDir = dir;
                }
            }
        }
        String ans = sp.toString();
        ArrayList<String> path = new ArrayList<>();
        for (int i = 0; i < ans.length(); i++) {
            path.add(ans.charAt(i) + "");
        }
        return factorizedForm(path);
    }

    public char getLeft(char c) {
        switch (c) {
            case ('E'):
                return 'N'; // Face North
            case ('N'):
                return 'W'; // Face West
            case ('S'):
                return 'E'; // Face East
            case ('W'):
                return 'S'; // Face South
            default:
                return '0';
        }
    }

    public char getRight(char c) {
        switch (c) {
            case ('E'):
                return 'S'; // Face South
            case ('N'):
                return 'E'; // Face East
            case ('S'):
                return 'W'; // Face West
            case ('W'):
                return 'N'; // Face North
            default:
                return '0';
        }

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
}