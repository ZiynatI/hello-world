package codewars;

import java.util.Arrays;

public class Snail {
    //Given an n x n array, return the array elements arranged from outermost elements to the middle element,
    //traveling clockwise.
    //array = [[1,2,3],
    //         [4,5,6],
    //         [7,8,9]]
    //snail(array) #=> [1,2,3,6,9,8,7,4,5]
    //For better understanding, please follow the numbers of the next array consecutively:
    //array = [[1,2,3],
    //         [8,9,4],
    //         [7,6,5]]
    //snail(array) #=> [1,2,3,4,5,6,7,8,9]
    //This image will illustrate things more clearly:
    //NOTE: The idea is not sort the elements from the lowest value to the highest; the idea is to traverse
    //the 2-d array in a clockwise snailshell pattern.
    //NOTE 2: The 0x0 (empty matrix) is represented as en empty array inside an array [[]].

    public static void main(String[] args) {
        int[][] field =
                {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                };
        System.out.println(Arrays.toString(snail(field)));
    }

    public static int[] snail(int[][] array) {
        if (array[0].length == 0) {
            return new int[0];
        }
        int elementsNum = array.length;
        int[] arranged = new int[elementsNum * elementsNum];
        int index = 0;
        int move = 1;
        int row = 0, cell = -1;
        while (elementsNum > 0) {
            for (int i = 0; i < elementsNum; i++) {
                cell += move;
                arranged[index] = array[row][cell];
                index++;
            }
            elementsNum--;
            for (int i = 0; i < elementsNum; i++) {
                row += move;
                arranged[index] = array[row][cell];
                index++;
            }
            move *= -1;
        }
        return arranged;
    }
}
