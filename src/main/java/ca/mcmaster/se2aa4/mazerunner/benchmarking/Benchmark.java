package ca.mcmaster.se2aa4.mazerunner.benchmarking;

import java.text.DecimalFormat;

import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.algorithms.BFSSol;
import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RHRuleSol;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;

public class Benchmark implements Perfomance {
    private String fileInput;
    private String m;
    private String b;

    public Benchmark(String fileInput, String m, String b) {
        this.fileInput = fileInput;
        this.m = m;
        this.b = b;
    }

    public void runPerformance() {
        Maze maze = testLoading();
        Path methodPath;
        Path baselinePath;

        if (m.equals("BFS")) {
            methodPath = testExploring(new BFSSol(), maze, m);
        } else {
            methodPath = testExploring(new RHRuleSol(), maze, m);
        }

        if (b.equals("BFS")) {
            baselinePath = testExploring(new BFSSol(), maze, b);
        } else {
            baselinePath = testExploring(new RHRuleSol(), maze, b);
        }

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
        maze.buildMaze();
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
