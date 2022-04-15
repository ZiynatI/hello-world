package org.helloworld.task;

public class Task4 {
    // посчитать количество цифр числа
    public static void main(String[] args) {
        long x = 331983105;
        System.out.println(countDigits(x));
        System.out.println(sumDigits(x));
    }

    public static int countDigits(long arg) {
        int count = 0;
        do {
            arg = arg / 10;
            count++;
        } while (arg > 1);
        return count;


    }

    public static int sumDigits(long arg) {
        long sum = 0;
        long a;
        do {
            a = arg % 10;
            arg = arg / 10;
            sum = sum + a;
        } while (arg > 1);

        return (int)sum;
    }
}
