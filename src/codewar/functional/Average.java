package codewar.functional;

public class Average {
    //https://www.codewars.com/kata/57a2013acf1fa5bfc4000921
    //Write a function which calculates the average of the numbers in a given list.
    //Note: Empty arrays should return 0.

    public static void main(String[] args) {
        System.out.println(findAverage(new int[]{1, 2, 3}));
        Runnable r = ()-> System.out.println("Hello world!");
        r.run();
    }

    public static double findAverage(int[] array) {
        Operations op = () -> {
            int sum = 0;
            for (int num : array) {
                sum += num;
            }
            return sum;
        };
        return op.calculate()/(double)array.length;
    }

    interface Operations {
        int calculate();
    }
}
