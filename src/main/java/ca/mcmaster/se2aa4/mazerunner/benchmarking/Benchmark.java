package ca.mcmaster.se2aa4.mazerunner.benchmarking;

import java.text.DecimalFormat;

import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFormatter;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public class Benchmark implements Perfomance {
    private PathFinder method;
    private PathFinder baseline;
    private String input;
    private PathFormatter format;
    private String m;
    private String b;

    public Benchmark(PathFinder method, PathFinder baseline, String input, PathFormatter format, String m,
            String b) {
        this.method = method;
        this.baseline = baseline;
        this.input = input;
        this.format = format;
        this.m = m;
        this.b = b;
    }

    public void runPerformance() {
        Maze maze = testLoading();
        String baselinePath = testExploring(baseline, maze, format, b);
        String methodPath = testExploring(method, maze, format, m);
        testSpeedUp(methodPath, baselinePath);
    }

    private void testSpeedUp(String mPath, String bPath) {
        DecimalFormat df = new DecimalFormat("0.##");
        double ans = bPath.length() * 1.0 / mPath.length();
        String formattedNumber = df.format(ans);
        System.out.println("The Speedup result: " + formattedNumber);
    }

    private Maze testLoading() {
        DecimalFormat df = new DecimalFormat("0.##");
        long startTime = System.nanoTime();

        Maze maze = loadingMazeTime(input);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        double milliseconds = duration / 1e6;
        String formattedNumber = df.format(milliseconds);
        System.out.println("Execution time for Loading the maze: " + formattedNumber + " milliseconds");
        return maze;
    }

    private Maze loadingMazeTime(String mazeInput) {
        return new Maze(mazeInput);
    }

    private String testExploring(PathFinder algo, Maze maze, PathFormatter format, String method) {
        DecimalFormat df = new DecimalFormat("0.##");
        long startTime = System.nanoTime();

        String path = exploringMazeMethod(algo, maze, format);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        double milliseconds = duration / 1e6;
        String formattedNumber = df.format(milliseconds);
        System.out.println("Execution time using method " + method + " for Exploring the maze: " + formattedNumber
                + " milliseconds");
        return path;
    }

    private String exploringMazeMethod(PathFinder algo, Maze maze, PathFormatter format) {
        return algo.mazeSolver(maze, format);
    }

}
