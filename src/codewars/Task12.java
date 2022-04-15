package codewars;

import java.util.*;

public class Task12 {
    public static void main(String[] args) {
        //Given an array of integers, find the one that appears an odd number of times.
        //There will always be only one integer that appears an odd number of times.
        //Examples:
        //[7] should return 7, because it occurs 1 time (which is odd).
        //[0] should return 0, because it occurs 1 time (which is odd).
        //[1,1,2] should return 2, because it occurs 1 time (which is odd).
        //[0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
        //[1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
        System.out.println(findIt(new int[]{1, 1, 2}));
        System.out.println(findIt(new int[]{0, 1, 0, 1, 0}));
        System.out.println(findIt(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));
    }

    public static int findIt(int[] a) {
        Set<Integer> numbers = new HashSet();
        for (int num : a) {
            if (numbers.contains(num)) {
                numbers.remove(num);
            } else {
                numbers.add(num);
            }
        }
        return numbers.iterator().next();
    }
}
