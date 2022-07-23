package codewars;

import java.util.Arrays;

public class SudokuValidator {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSortedDigits()));
        System.out.println(check((new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        })));
        System.out.println(checkBlocks(new int[][]{
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        }));
    }

    //Sudoku Solution Validator
    //Write a function validSolution/ValidateSolution/valid_solution() that accepts a 2D array representing a
    //Sudoku board, and returns true if it is a valid solution, or false otherwise. The cells of the sudoku
    //board may also contain 0's, which will represent empty cells. Boards containing one or more zeroes are
    //considered to be invalid solutions.
    //The board is always 9 cells by 9 cells, and every cell only contains integers from 0 to 9.
    //Sudoku is a game played on a 9x9 grid. The goal of the game is to fill all cells of the grid with digits
    //from 1 to 9, so that each column, each row, and each of the nine 3x3 sub-grids (also known as blocks)
    //contain all of the digits from 1 to 9.
    public static boolean check(int[][] sudoku) {
        if (checkBlocks(sudoku)) {
            if (checkColumns(sudoku)) {
                return checkRows(sudoku);
            }
        }
        return false;
    }

    public static int[] getSortedDigits() {
        int[] digits = new int[9];
        for (int i = 0; i < 9; i++) {
            digits[i] = i + 1;
        }
        return digits;
    }

    public static boolean checkBlocks(int[][] sudoku) {
        int[] digits = getSortedDigits();
        for (int i = 0; i < 9; i = i + 3) {
            for (int m = i; m < 9; m = m + 3) {
                int index = 0;
                int[] blockArray = new int[9];
                for (int j = i; j < i + 3; j++) {
                    for (int k = m; k < m + 3; k++) {
                        blockArray[index] = sudoku[j][k];
                        index++;
                    }
                }
                Arrays.sort(blockArray);
                if (!Arrays.equals(blockArray, digits)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkRows(int[][] sudoku) {
        int[] digits = getSortedDigits();
        for (int[] ints : sudoku) {
            Arrays.sort(ints);
            if (!Arrays.equals(ints, digits)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkColumns(int[][] sudoku) {
        int[] digits = getSortedDigits();
        for (int i = 0; i < sudoku.length; i++) {
            int[] columnsArray = new int[9];
            for (int j = 0; j < sudoku.length; j++) {
                columnsArray[j] = sudoku[j][i];
            }
            Arrays.sort(columnsArray);
            if (!Arrays.equals(columnsArray, digits)) {
                return false;
            }
        }
        return true;
    }

}
