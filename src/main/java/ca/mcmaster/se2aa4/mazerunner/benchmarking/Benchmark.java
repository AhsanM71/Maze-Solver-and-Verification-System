package ca.mcmaster.se2aa4.mazerunner.benchmarking;

import java.text.DecimalFormat;

import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public class Benchmark implements Perfomance {
    private PathFinder method;
    private PathFinder baseline;
    private String fileInput;
    private String m;
    private String b;

    public Benchmark(PathFinder method, PathFinder baseline, String fileInput, String m, String b) {
        this.method = method;
        this.baseline = baseline;
        this.fileInput = fileInput;
        this.m = m;
        this.b = b;
    }

    public void runPerformance() {
        Maze maze = testLoading();
        Path baselinePath = testExploring(baseline, maze, b);
        Path methodPath = testExploring(method, maze, m);
        testSpeedUp(methodPath, baselinePath);
    }

    private void testSpeedUp(Path mPath, Path bPath) {
        DecimalFormat df = new DecimalFormat("0.##");
        double ans = bPath.getPath().length() * 1.0 / mPath.getPath().length();
        String formattedNumber = df.format(ans);
        System.out.println("The Speedup result: " + formattedNumber);
    }

    private Maze testLoading() {
        DecimalFormat df = new DecimalFormat("0.##");
        long startTime = System.nanoTime();

        Maze maze = new Maze(fileInput);

        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        double milliseconds = duration / 1e6;
        String formattedNumber = df.format(milliseconds);
        System.out.println("Execution time for Loading the maze: " + formattedNumber + " milliseconds");
        return maze;
    }

    private Path testExploring(PathFinder algo, Maze maze, String method) {
        DecimalFormat df = new DecimalFormat("0.##");
        Path format = new Path("");
        long startTime = System.nanoTime();

        Path path = algo.mazeSolver(maze, format);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        double milliseconds = duration / 1e6;
        String formattedNumber = df.format(milliseconds);
        System.out.println("Execution time using method " + method + " for Exploring the maze: " + formattedNumber
                + " milliseconds");
        return path;
    }
}
