package codewars;

import java.util.Map;

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
        System.out.println(nSquaresFor(15));
    }

    public static int nSquaresFor(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 == 0) {
            return 1;
        }
        //An integer greater than one can be written as a sum of two squares if and only if its prime
        //decomposition contains no factor p^k, where prime p ≡ 3 ( mod 4 ) and k is odd.
        int m = n;
        Map<Integer,Integer> factorized = FactorToPrimes.factorToPrimes(m);
        boolean twoSquares=true;
        for (Map.Entry<Integer, Integer> prime : factorized.entrySet()) {
            if(((prime.getKey()%4==3)&&prime.getValue()%2!=0)){
                twoSquares=false;
            }
        }
        if (twoSquares){
            return 2;
        }
        //Теорема Лежандра о трёх квадратах утверждает, что натуральное число может быть представлено суммой трёх квадратов целых чисел
        // n=x^{2}+y^{2}+z^{2} тогда и только тогда, когда n не представимо в виде n=4^{a}(8b+7), где a и b целые.

        int s = n;
        while (s % 4 == 0) {
            s = s / 4;
        }
        if (s % 8 != 7) {
            return 3;
        }
        //Теорема Лагранжа о сумме четырёх квадратов утверждает, что
        //всякое натуральное число можно представить в виде суммы четырёх квадратов целых чисел.
        return 4;
    }
}
