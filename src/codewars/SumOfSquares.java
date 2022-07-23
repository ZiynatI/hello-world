package codewars;

public class SumOfSquares {
    //The task is simply stated. Given an integer n (3 < n < 109), find the length of the smallest list
    //of perfect squares which add up to n. Come up with the best algorithm you can; you'll need it!
    //Examples:
    //    sum_of_squares(17) = 2
    //    17 = 16 + 1 (4 and 1 are perfect squares).
    //    sum_of_squares(15) = 4
    //    15 = 9 + 4 + 1 + 1. There is no way to represent 15 as the sum of three perfect squares.
    //    sum_of_squares(16) = 1
    //    16 itself is a perfect square.
    //Time constraints:
    //5 easy (sample) test cases: n < 20
    //5 harder test cases: 1000 < n < 15000
    //5 maximally hard test cases: 5e8 < n < 1e9
    //300 random maximally hard test cases: 1e8 < n < 1e9

    public static void main(String[] args) {
        System.out.println(nSquaresFor(1529));
    }

    public static int nSquaresFor(int n) {
    return 0;
    }


    //    public static int nSquaresFor(int n) {
    //        int length = n;
    //        int count = 0;
    //        int a = (int) Math.sqrt(n);
    //        for (int i = a; i <n; i--) {
    //            while (n > 0) {
    //                n -= i*i;
    //                count++;
    //            }
    //            if (count < length) {
    //                length = count;
    //            }
    //            count = 0;
    //        }
    //
    //        return length;
    //    }
}
