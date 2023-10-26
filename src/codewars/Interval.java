package codewars;

import java.util.*;

//https://www.codewars.com/kata/52b7ed099cdc285c300001cd
/*Sum of intervals
Write a function called sumIntervals/sum_intervals that accepts an array of intervals, and returns the sum of all the interval lengths.
Overlapping intervals should only be counted once.
Intervals are represented by a pair of integers in the form of an array.
The first value of the interval will always be less than the second value. Interval example: [1, 5] is an interval from 1 to 5.
The length of this interval is 4.
Overlapping Intervals:
List containing overlapping intervals:
[
   [1, 4],
   [7, 10],
   [3, 5]
]
The sum of the lengths of these intervals is 7. Since [1, 4] and [3, 5] overlap, we can treat the interval as [1, 5], which has a length of 4.
Examples:

sumIntervals( [
   [1, 2],
   [6, 10],
   [11, 15]
] ) => 9

sumIntervals( [
   [1, 4],
   [7, 10],
   [3, 5]
] ) => 7

sumIntervals( [
   [1, 5],
   [10, 20],
   [1, 6],
   [16, 19],
   [5, 11]
] ) => 19

sumIntervals( [
   [0, 20],
   [-100000000, 10],
   [30, 40]
] ) => 100000030

Tests with large intervals
Your algorithm should be able to handle large intervals. All tested intervals are subsets of the range [-1000000000, 1000000000].
*/


public class Interval {

    public static void main(String[] args) {
        System.out.println(sumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
    }

    public static int sumIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        List<int[]> intervalsList = Arrays.asList(intervals);
        //Sort the list so the first num of next interval is always bigger than preceding one's or equal to
        intervalsList.sort(Comparator.comparing(a -> a[0]));
        //Create a new list of intervals, compare intervals from existing list with each in new list, if they overlap combine them,
        //so you will not have overlapping intervals
        List<int[]> creatingList = new ArrayList<>();
        creatingList.add(intervalsList.get(0));
        for (int i = 1; i < intervalsList.size(); i++) {
            boolean overlapped = false;
            for (int j = 0; j < creatingList.size(); j++) {

                if (creatingList.get(j)[1] > intervalsList.get(i)[0]) {
                    if (intervalsList.get(i)[1] >= creatingList.get(j)[1]) {
                        creatingList.get(j)[1] = intervalsList.get(i)[1];
                        overlapped = true;
                        break;
                    } else {
                        overlapped = true;
                    }
                }
            }
            if (!overlapped) {
                creatingList.add(intervalsList.get(i));
            }
        }
        int sumOfIntervals = 0;
        for (int[] ints : creatingList) {
            sumOfIntervals += ints[1] - ints[0];
        }
        return sumOfIntervals;
    }
}
