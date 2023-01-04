package codewars;

import java.util.Arrays;

public class HowManyAreSmallerThanMeII {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smaller(new int[]{5, 4, 3, 2, 1})));
    }

    //https://www.codewars.com/kata/56a1c63f3bc6827e13000006
    //Write
    //function smaller(arr)
    //that given an array arr, you have to return the amount of numbers that are smaller than arr[i] to the right.
    //For example:
    //
    //smaller([5, 4, 3, 2, 1]) === [4, 3, 2, 1, 0]
    //smaller([1, 2, 0]) === [1, 1, 0]
    public static int[] smaller(int[] unsorted) {
        int[] countOfSmallers = new int[unsorted.length];
        for (int i = unsorted.length - 1; i < unsorted.length - 1; i++) {
            int smallers = 0;
            for (int j = i + 1; j < unsorted.length; j++) {
                if (unsorted[i] > unsorted[j]) {
                    smallers++;
                }
            }
            countOfSmallers[i] = smallers;
        }
        countOfSmallers[countOfSmallers.length - 1] = 0;
        return countOfSmallers;
    }

    public static int[] smaller2(int[] unsorted) {
        int smallest = 0;
        int biggest = 0;
        for (int num : unsorted) {
            if (smallest > num) {
                smallest = num;
            }
            if (biggest < num) {
                biggest = num;
            }
        }


        return null;
    }
}
