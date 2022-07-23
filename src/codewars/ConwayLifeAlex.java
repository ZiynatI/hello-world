// Copyright (c) YugaByte, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.  You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software distributed under the License
// is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
// or implied.  See the License for the specific language governing permissions and limitations
// under the License.
//

package codewars;

public class ConwayLifeAlex {
  public static final int DEAD  = 0;
  public static final int ALIVE = 1;

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

  public static void main(String[] args) {
    int[][] start =
        {
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0 }
        };
    for (int g = 0; g <=  1; ++g) {
      System.out.println("Round " + g + ":");
      int[][] f = getGeneration(start, g);
      print(f);
      System.out.println();
    }
  }

  /** Assumes field has at least one row. */
  public static int[][] getGeneration(int[][] field, int generations) {
    int[][] result = field;
    for (int g = 0; g < generations; g++) {
      result = getNextGeneration(result);
    }
    return result;
  }

  /** Assumes field has at least one row. */
  public static int[][] getNextGeneration(int[][] field) {
    int[][] result = new int[field.length][field[0].length];
    for (int r = 0; r < field.length; ++r) {
      for (int c = 0; c < field[r].length; ++c) {
        result[r][c] = getNewCellState(field, r, c);
      }
    }
    return result;
  }

  public static int getNewCellState(int[][] field, int r, int c) {
    int numNeighbors = countNeighbors(field, r, c);
    switch (field[r][c]) {
      case DEAD:
        if (numNeighbors == 3) {
          return ALIVE;
        }
        return DEAD;
      case ALIVE:
        if (numNeighbors == 2 || numNeighbors == 3) {
          return ALIVE;
        }
        return DEAD;
      default:
        throw new IllegalStateException("Unknown cell state: " + field[r][c]);
    }
  }

  public static void print(int[][] field) {
    for (int[] rows : field) {
      for (int cell : rows) {
        System.out.print(cell == DEAD ? "░░" : "▓▓");
      }
      System.out.println();
    }
  }

  public static int countNeighbors(int[][] field, int r, int c) {
    final int nRows = field.length;
    final int nCols = field[0].length;

    int result = 0;
    for (int rShift = -1; rShift <= 1; ++rShift) {
      int r2 = (r + rShift + nRows) % nRows;
      for (int cShift = -1; cShift <= 1; ++cShift) {
        int c2 = (c + cShift + nCols) % nCols;

        if (field[r2][c2] == ALIVE) {
          ++result;
        }
      }
    }

    return field[r][c] == ALIVE ? result - 1 : result; // Subtract self
  }
}
