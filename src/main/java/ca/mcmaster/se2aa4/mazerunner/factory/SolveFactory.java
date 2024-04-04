package ca.mcmaster.se2aa4.mazerunner.factory;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.Path;
import ca.mcmaster.se2aa4.mazerunner.algorithms.BFSSol;
import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RHRuleSol;
import ca.mcmaster.se2aa4.mazerunner.benchmarking.Benchmark;
import ca.mcmaster.se2aa4.mazerunner.benchmarking.Perfomance;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.verification.PathVerifier;

public class SolveFactory implements AlgorithmFactory {
    private static final Logger logger = LogManager.getLogger();

    public void runMazeSolver(List<String> paths, Maze maze, PathVerifier verify) {
        String mazeInput = paths.get(0);
        String path = paths.get(1);
        String method = paths.get(2);
        String baseline = paths.get(3);
        Path p = new Path(path);
        PathFinder rightHandRule;
        PathFinder bfs;

        if (!baseline.equals("null")) {
            try {
                verify(method, baseline);
                rightHandRule = new RHRuleSol();
                bfs = new BFSSol();
                Perfomance benchmark;
                if (method.equals("righthand")) {
                    benchmark = new Benchmark(rightHandRule, bfs, mazeInput, method, baseline);
                } else {
                    benchmark = new Benchmark(bfs, rightHandRule, mazeInput, method, baseline);

                }
                benchmark.runPerformance();
            } catch (IllegalArgumentException e) {
                System.out.println("An illegal argument exception occurred: " + e.getMessage());
            }

        }

        else if (path.equals("null")) {
            if (method.equals("righthand")) {
                rightHandRule = new RHRuleSol();
                runMethod(rightHandRule, maze, p);
            } else if (method.equals("BFS")) {
                bfs = new BFSSol();
                runMethod(bfs, maze, p);
            }
        } else {
            if (verify.verifyGivenPath(maze, p)) {
                System.out.println("correct path");
            } else {
                System.out.println("incorrect path");
            }
        }
    }

    private void runMethod(PathFinder algo, Maze maze, Path format) {
        Path solvedPath = algo.mazeSolver(maze, format);
        if (solvedPath.getPath().length() > -1) {
            System.out.println(format.canonicalToFactorized());
        } else {
            logger.info("PATH NOT COMPUTED");
        }
    }

    private void verify(String m, String b) {
        if (m.equals(b)) {
            throw new IllegalArgumentException("benchmarking the same algorithm");
        }
    }
}
