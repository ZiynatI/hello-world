package org.helloworld.task;

import java.util.Scanner;

public class Task15 {
    public static void main(String[] args) {
        //определить, является ли число N простым
        Scanner s = new Scanner(System.in);
        System.out.println("Введите число");
        int n = s.nextInt();
        if (isPrime(n)) {
            System.out.println("Данное число является простым");
        } else {
            System.out.println("Данное число не является простым");
        }
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
}