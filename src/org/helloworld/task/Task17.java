package org.helloworld.task;

import java.util.Scanner;

public class Task17 {
    public static void main(String[] args) {
        //решето Эратосфена
        //ты определяешь дальнейшие простые числа с помощью уже определённых тобой ранее простых чисел
        System.out.println("Введите число");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(arrayToString(getPrimesUpTo(n)));


        //        String primeNumbersString = "[";
        //        int[] primeNumbersarray = new int[1000];
        //        int numberOfNewElement = 1;
        //        primeNumbersarray[0] = 2;
        //        boolean isPrime = true;
        //        for (int i = 3; i < n; i++) {
        //            for (int j = 0; j < primeNumbersarray.length; j++) {
        //                if (primeNumbersarray[j] == 0 || primeNumbersarray[j] == i) {
        //                    isPrime = true;
        //                    break;
        //                } else if (i % primeNumbersarray[j] == 0) {
        //                    isPrime = false;
        //                    break;
        //                }
        //            }
        //            if (isPrime) {
        //                primeNumbersarray[numberOfNewElement] = i;
        //                numberOfNewElement++;
        //            }
        //        }
        //        for (int i = 0; i < primeNumbersarray.length; i++) {
        //            if (primeNumbersarray[i] == 0) {
        //                break;
        //            }
        //            if (i > 0) {
        //                primeNumbersString = primeNumbersString + ", ";
        //            }
        //            primeNumbersString = primeNumbersString + primeNumbersarray[i];
        //        }
        //        System.out.println(primeNumbersString + "]");

    }

    public static int[] getPrimesUpTo(int lastNumber) {
        long startTimeMs = System.currentTimeMillis();
        int[] primeArray = new int[10000000];
        int newElementsNumber = 1;
        primeArray[0] = 2;
        for (int i = 3; i < lastNumber; i++) {
            boolean isPrime = true;
            double sqrt = Math.sqrt(i);
            for (int j = 0; j < primeArray.length; j++) {
                if (primeArray[j] > sqrt) {
                    break;
                } else if (i % primeArray[j] == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeArray[newElementsNumber] = i;
                newElementsNumber++;
            }
        }
        long endTimeMs = System.currentTimeMillis();
        System.out.println("Простые числа посчитаны за " + (endTimeMs - startTimeMs) + " миллисекунд");
        return primeArray;
    }

    public static String arrayToString(int[] arr) {
        StringBuilder primeString = new StringBuilder("[");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                break;
            }
            if (i > 0) {
                primeString.append(", ");
            }
            primeString.append(arr[i]);
        }
        String result = new String(primeString+"]");
        return result;
    }
}