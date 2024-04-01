package ca.mcmaster.se2aa4.mazerunner.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.runner.Direction;
import ca.mcmaster.se2aa4.mazerunner.runner.Player;
import ca.mcmaster.se2aa4.mazerunner.runner.Position;
import ca.mcmaster.se2aa4.mazerunner.runner.Runner;

public class BFSSol implements PathFinder {

    public String mazeSolver(Maze maze, PathFormatter format) {
        int cols = maze.getMazeCSize();
        int rows = maze.getMazeRSize();
        Set<Position> visited = new HashSet<>();
        Map<Position, Position> path = new HashMap<>();
        Queue<Position> queue = new LinkedList<>();
        Position start = maze.findStartPos();
        Position end = maze.findEndPos();
        Player runner = new Runner(start.getYVal(), start.getXVal(), Direction.EAST, end.getYVal(), end.getXVal());
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
        return shortestPath(shortestPath, prevDir, format);
    }

    private boolean isValid(int newX, int newY, int rows, int cols, Position neighbour, Maze maze,
            Set<Position> visited) {
        return newX >= 0 && newX < cols && newY >= 0 && newY < rows && maze.isPathValid(newX, newY)
                && !visited.contains(neighbour);
    }

    private String shortestPath(List<Position> path, Direction prevDir, PathFormatter format) {
        List<Direction> directions = new ArrayList<>();
        for (int i = 1; i < path.size(); i++) {
            Position prev = path.get(i - 1);
            Position curr = path.get(i);
            int dx = curr.getXVal() - prev.getXVal();
            int dy = curr.getYVal() - prev.getYVal();

            if (dy == 0 && dx == 1) {
                directions.add(Direction.EAST);
            } else if (dy == 0 && dx == -1) {
                directions.add(Direction.WEST);
            } else if (dy == 1 && dx == 0) {
                directions.add(Direction.SOUTH);
            } else if (dy == -1 && dx == 0) {
                directions.add(Direction.NORTH);
            }
        }
        return converter(directions, prevDir, format);
    }

    private String converter(List<Direction> directions, Direction prevDir, PathFormatter format) {
        StringBuilder sp = new StringBuilder();
        for (int i = 0; i < directions.size(); i++) {
            Direction dir = directions.get(i);
            if (dir.equals(prevDir)) {
                sp.append("F");
            } else {
                if (dir.equals(prevDir.getLeftDir())) {
                    sp.append("LF");
                    prevDir = dir;
                } else {
                    sp.append("RF");
                    prevDir = dir;
                }
            }
        }
        return format.factorizedForm(format.strToList(sp.toString()));
    }
}