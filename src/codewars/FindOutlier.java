package codewars;

public class FindOutlier {
    //https://www.codewars.com/kata/5526fc09a1bbd946250002dc
    //You are given an array (which will have a length of at least 3, but could be very large) containing integers.
    //The array is either entirely comprised of odd integers or entirely comprised of even integers except
    //for a single integer N. Write a method that takes the array as an argument and returns this "outlier" N.
    //Examples
    //
    //[2, 4, 0, 100, 4, 11, 2602, 36]
    //Should return: 11 (the only odd number)
    //
    //[160, 3, 1719, 19, 11, 13, -21]
    //Should return: 160 (the only even number)

    public static void main(String[] args) {
        System.out.println(find(new int[]{160, 3, 1719, 19, 11, 13, -21}));
    }

    static int find(int[] integers) {
        int evensInFirstThree = 0;
        for (int i = 0; i < 3; i++) {
            if (integers[i] % 2 == 0) {
                evensInFirstThree++;
            }
        }
        boolean moreEvens = evensInFirstThree >= 2;
        boolean outlierFound = false;
        int index = 0;
        while (!outlierFound) {
            boolean isEven = integers[index] % 2 == 0;
            outlierFound = moreEvens != isEven;
            index++;
        }
        return integers[index - 1];
    }
}
