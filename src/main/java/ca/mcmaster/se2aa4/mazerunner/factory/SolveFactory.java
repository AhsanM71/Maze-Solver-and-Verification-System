package ca.mcmaster.se2aa4.mazerunner.factory;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.algorithms.BFSSol;
import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFinder;
import ca.mcmaster.se2aa4.mazerunner.algorithms.PathFormatter;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RHRuleSol;
import ca.mcmaster.se2aa4.mazerunner.benchmarking.Benchmark;
import ca.mcmaster.se2aa4.mazerunner.maze.Maze;
import ca.mcmaster.se2aa4.mazerunner.path.VerifyPath;

public class SolveFactory implements AlgorithmFactory {
    private static final Logger logger = LogManager.getLogger();
    private PathFinder rightHandRule, bfs;

    public void runMazeSolver(List<String> paths, Maze maze, PathFormatter format, VerifyPath verify) {
        String Mazeinput = paths.get(0);
        String path = paths.get(1);
        String method = paths.get(2);
        String baseline = paths.get(3);

        if (!baseline.equals("null")) {
            rightHandRule = new RHRuleSol();
            bfs = new BFSSol();
            Benchmark benchmark = new Benchmark(bfs, rightHandRule, Mazeinput, format, method, baseline);
            benchmark.runPerformance();
        }

        else if (path.equals("null")) {
            if (method.equals("righthand")) {
                rightHandRule = new RHRuleSol();
                runMethod(rightHandRule, maze, format);
            } else if (method.equals("BFS")) {
                bfs = new BFSSol();
                runMethod(bfs, maze, format);
            }
        } else {
            Boolean isValid = verify.verifyGivenPath(maze, path);
            if (isValid) {
                System.out.println("correct path");
            } else {
                System.out.println("incorrect path");
            }
        }
    }

    private void runMethod(PathFinder algo, Maze maze, PathFormatter format) {
        String solvedPath = algo.mazeSolver(maze, format);
        if (solvedPath.length() > -1) {
            System.out.println(solvedPath);
        } else {
            logger.info("PATH NOT COMPUTED");
        }
    }
}
