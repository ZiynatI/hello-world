package codewars;

import java.util.ArrayList;
import java.util.List;

public class HowManyNumbers {
    //We want to generate all the numbers of three digits where:
    //    the sum of their digits is equal to 10
    //    their digits are in increasing order (the numbers may have two or more equal contiguous digits)
    //The numbers that fulfill these constraints are: [118, 127, 136, 145, 226, 235, 244, 334].
    //There are 8 numbers in total with 118 being the lowest and 334 being the greatest.
    //Task:
    //Implement a function which receives two arguments:
    //    the sum of digits (sum)
    //    the number of digits (count)
    //This function should return three values:
    //    the total number of values which have count digits that add up to sum and are in increasing order
    //    the lowest such value
    //    the greatest such value
    //Note: if there are no values which satisfy these constants, you should return an empty value
    //(refer to the examples to see what exactly is expected).
    //Examples:
    //// The output type is List<Long>
    //HowManyNumbers.findAll(10, 3)  =>  [8, 118, 334]
    //HowManyNumbers.findAll(27, 3)  =>  [1, 999, 999]
    //HowManyNumbers.findAll(84, 4)  =>  []
    //Features of the random tests:
    //    Number of tests: 112
    //    Sum of digits value between 20 and 65
    //    Amount of digits between 2 and 17

    public static void main(String[] args) {
        System.out.println(findAll(10, 3));
    }


    public static List<Long> findAll(final int sumDigits, final int numDigits) {
        if (sumDigits > numDigits * 9) {
            return new ArrayList<>();
        }
        List<Long> numbers = new ArrayList<>();
        for (long i = (long) Math.pow(10, numDigits - 1); i < (long) Math.pow(10, numDigits); i++) {
            long num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num = (num - num % 10) / 10;
            }
            if (sum == sumDigits && isInIncreasingOrder(i)) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public static boolean isInIncreasingOrder(long number) {
        long num = number;
        int tail = (int) (num % 10);
        num = (num - tail) / 10;
        while (num > 0) {
            if (num % 10 > tail) {
                return false;
            }
            tail = (int) (num % 10);
            num = (num - num % 10) / 10;
        }
        return true;
    }
}
