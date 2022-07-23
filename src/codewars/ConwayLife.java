package codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConwayLife {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getGeneration(new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        }, 2)));
    }

    //Given a 2D array and a number of generations, compute n timesteps of Conway's Game of Life.
    //The rules of the game are:
    //    Any live cell with fewer than two live neighbours dies, as if caused by underpopulation.
    //    Any live cell with more than three live neighbours dies, as if by overcrowding.
    //    Any live cell with two or three live neighbours lives on to the next generation.
    //    Any dead cell with exactly three live neighbours becomes a live cell.
    //Each cell's neighborhood is the 8 cells immediately around it (i.e. Moore Neighborhood).
    //The universe is infinite in both the x and y dimensions and all cells are initially dead -
    //except for those specified in the arguments. The return value should be a 2d array cropped around
    //all of the living cells. (If there are no living cells, then return [[]].)
    //For illustration purposes, 0 and 1 will be represented as ░░ and ▓▓ blocks respectively.
    //You can take advantage of the htmlize function to get a text representation of the universe, e.g.:
    //System.out.println(LifeDebug.htmlize(cells));
    public static int[][] getGeneration(int[][] cells, int generations) {
        int doneGenerations = 0;
        do {
            List<Integer> neighbours = countNeighbours(cells);
            int cellsNum = 0;
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[i].length; j++) {
                    if (cells[i][j] == 0) {
                        if (neighbours.get(cellsNum) == 3) {
                            cells[i][j] = 1;
                        }
                    } else if (
                            cells[i][j] == 1) {
                        if (neighbours.get(cellsNum) > 3 || neighbours.get(cellsNum) < 2) {
                            cells[i][j] = 0;
                        }
                    }
                    cellsNum++;
                }
            }
            doneGenerations++;
        } while (doneGenerations != generations);
        return cells;
    }

    public static List<Integer> countNeighbours(int[][] cells) {
        List<Integer> neighbours = new ArrayList<>();
        int numOfNeighbours = 0;
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                neighbours.add(numOfNeighbours, checkNeighbours(cells, i, j));
                numOfNeighbours++;
            }
        }
        return neighbours;
    }

    public static int checkNeighbours(int[][] cells, int i, int j) {
        int aliveNeighbours = 0;
        for (int k = i - 1; k < 3; k++) {
            if (k < 0 || k > cells.length) {
                break;
            }
            for (int l = j - 1; l < 3; l++) {
                if (l < 0 || l > cells.length) {
                    break;
                }
                if (cells[k][j] == 1) {
                    aliveNeighbours++;
                }
            }
        }
        return aliveNeighbours;
    }
}

