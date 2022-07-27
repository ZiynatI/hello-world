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
        System.out.println(nSquaresFor(7));
    }

    public static int nSquaresFor(int n) {
        double sqrt = Math.sqrt(n);
        if(sqrt%1==0){
            return 1;
        }
        //Теорема Ферма — Эйлера гласит:Любое простое число p = 4 n + 1, где n — натуральное число,
        //представимо в виде суммы квадратов двух натуральных чисел.
        if (n % 4 == 1) {
            return 2;
        }
        //Теорема Лежандра о трёх квадратах утверждает, что натуральное число может быть представлено суммой трёх квадратов целых чисел
        // n=x^{2}+y^{2}+z^{2} тогда и только тогда, когда n не представимо в виде n=4^{a}(8b+7), где a и b целые.
        if (!numberWhichIsNotSumOfThreeSquares(n)){
            int m = n;
           while (m%4==0){
               m=m/4;
           }if(m%8==7){
               return 3;
            }

        }
        //Теорема Лагранжа о сумме четырёх квадратов утверждает, что
        //всякое натуральное число можно представить в виде суммы четырёх квадратов целых чисел.
            return 4;
    }


    public static boolean numberWhichIsNotSumOfThreeSquares(int n) {
        //В частности, числами не представимыми суммой трёх квадратов и представимыми в виде n=4^{a}(8b+7) являются элементы данного массива
        int[] numbers = new int[]{
                7, 15, 23, 28, 31, 39, 47, 55, 60, 63, 71, 79, 87, 92, 95,
                103, 111, 112, 119, 124, 127, 135, 143, 151, 156, 159, 167,
                175, 183, 188, 191, 199, 207, 215, 220, 223, 231, 239, 240,
                247, 252, 255, 263, 271, 279, 284, 287, 295, 303, 311, 316,
                319, 327, 335, 343};
        for (int i = 0; i < numbers.length; i++) {
            if (n == numbers[i]) {
                return true;
            }
        }
        return false;
    }
}
