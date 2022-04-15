package org.helloworld.task;

import java.util.Arrays;
import java.util.Scanner;

public class Task16 {
    public static void main(String[] args) {
        /*теперь сложнее веселее)
        сделай функцию, которая находит все простые числа от 1 до N и возвращает их массив
        (скажем, массив на 100 элементов)*/
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число");
        int n = s.nextInt();

        System.out.println(getPrimesUpTo(n));

    }

    public static boolean isPrime(int arg) {
        double sqrt = Math.sqrt(arg);
        for (int i = 2; i <= sqrt; i++) {
            if (arg % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int[] getPrimesUpTo(int lastNumber) {
        int[] primeArray = new int[10000000];
        long startTimeMs = System.currentTimeMillis();
        int k = 0;
        for (int i = 2; i < lastNumber; i++) {
            if (isPrime(i) == true) {
                primeArray[k] = i;
                k++;
            }
        }
        long endTimeMs = System.currentTimeMillis();
        System.out.println("Простые числа посчитаны за " + (endTimeMs - startTimeMs) + " миллисекунд");
        return primeArray;
    }

    public static String arrayToString(int[] arr) {
        String primeNumbers = "[";
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            if (i > 0) {
                primeNumbers = primeNumbers + ", ";
            }
            primeNumbers = primeNumbers + arr[i];
        }
        return primeNumbers + "]";
    }
}