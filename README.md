[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/8jM7fhXE)

# Assignment A3 - Maze Runner

- **Student**: [Ahsan Muzammil](muzammia@mcmaster.ca)
- **Program**: B. Eng. In Software Engineering
- **Course code**: SFWRENG 2AA4
- **Course Title**: Software Design I - Introduction to Software Development
- Term: _Level II - Winter 2024_

## Business Logic Specification

This program explores a maze, finding a path from an entry point to an exit one.

- The maze is stored in a text file, with `#` representing walls and `␣` (_empty space_) representing passages.
- You’ll find examples of such mazes in the [`examples`](./examples) directory.
  - You can also use the [Maze Generator](https://github.com/ace-lectures/maze-gen) to generate others.
- The Maze is surrounded by walls on its four borders, except for its entry/exit points.
  - Entry and exit points are always located on the East and West border.
  - The maze is not directed. As such, exit and entry can be interchanged.
- At the beginning of the exploration, we're located on the entry tile, facing the opposite side (e.g., if entering by the eastern entry, you're facing West).
- The program generates a sequence of instructions to reach the opposite exit (i.e., a "path"):
  - `F` means 'move forward' according to your current direction
  - `R` means 'turn right' (does not move, just change direction), and `L` means ‘turn left’.
- A canonical path contains only `F`, `R` and `L` symbols
- A factorized path squashes together similar instructions (i.e., `FFF` = `3F`, `LL` = `2L`).
- Spaces are ignored in the instruction sequence (only for readability: `FFLFF` = `FF L FF`)
- The program takes as input a maze and print the path on the standard output.
  - For this assignment, the path does not have to be the shortest one.
- The program can take a path as input and verify if it's a legit one.

## How to run this software?

To build the program, simply package it with Maven:

```
mosser@azrael A3-Template % mvn -q clean package
```

### Provided version (starter code)

The starter code assumes the maze file name is the first argument.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar ./examples/small.maz.txt
** Starting Maze Runner
**** Reading the maze from file ./examples/small.maz.txt
WALL WALL WALL WALL WALL WALL WALL WALL WALL WALL WALL
WALL PASS PASS PASS PASS PASS PASS PASS PASS PASS WALL
WALL WALL WALL PASS WALL WALL WALL PASS WALL WALL WALL
WALL PASS PASS PASS PASS PASS WALL PASS PASS PASS WALL
WALL PASS WALL PASS WALL WALL WALL WALL WALL PASS WALL
WALL PASS WALL PASS PASS PASS PASS PASS WALL PASS PASS
WALL WALL WALL PASS WALL PASS WALL WALL WALL WALL WALL
WALL PASS PASS PASS WALL PASS PASS PASS PASS PASS WALL
PASS PASS WALL PASS WALL PASS WALL WALL WALL PASS WALL
WALL PASS WALL PASS WALL PASS WALL PASS PASS PASS WALL
WALL WALL WALL WALL WALL WALL WALL WALL WALL WALL WALL
**** Computing path
PATH NOT COMPUTED
** End of MazeRunner
```

When called on a non-existing file. it prints an error message

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar ./examples/small.maz.txt
** Starting Maze Runner
**** Reading the maze from file ./examples/small.maz.txtd
/!\ An error has occured /!\
**** Computing path
PATH NOT COMPUTED
** End of MazeRunner
```

### Delivered version

#### Command line arguments

The delivered program at the end of this assignment should use the following flags:

- `-i MAZE_FILE`: specifies the filename to be used;
- `-p PATH_SEQUENCE`: activates the path verification mode to validate that PATH_SEQUENCE is correct for the maze
- `-m PREFERRED_METHOD`: activates the maze solving mode to solve the maze with PREFERRED_METHOD
- `-b BENCHMARK_MODE`: activates the benchmarking mode where when combined with -m and -b flag the program runs BENCHMARK_MODE

If you are also delivering the bonus, your program will react to a third flag:

- `-method {BFS, righthand}`: specifies which path computation method to use. (default is right hand)

#### Examples

When no logs are activated or no -m preferred method is provided, the programs only print the computed path on the standard output using righthand rule.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt
4F
mosser@azrael A3-Template %
```

When no logs are activated and a -m preferred method is provided, the programs only print the computed path on the standard output using the preferred method.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -m BFS
4F
mosser@azrael A3-Template %
```

If a given path is correct, the program prints the message `correct path` on the standard output.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p 4F
correct path
mosser@azrael A3-Template %
```

If a given path is incorrect, the program prints the message `incorrect path` on the standard output.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p 3F
inccorrect path
mosser@azrael A3-Template %
```

If in benchmark mode, the program prints the message for results of the benchmark on the standard output.

```
mosser@azrael A3-Template % java -jar target/mazerunner.jar -i ./examples/giant.maz.txt -m BFS -b righthand
Execution time for Loading the maze: 2.4 milliseconds
Execution time using method BFS for Exploring the maze: 28.64 milliseconds
Execution time using method righthand for Exploring the maze: 7.16 milliseconds
The Speedup result: 75.88
mosser@azrael A3-Template %
```
