package org.helloworld.demo;

public class RecursionDemo {

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(fibonacci(10));
        System.out.println(isPrime(1));
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            // n! = (n-1)! * n
            int nMinusOneF = factorial(n - 1);
            return nMinusOneF * n;
        }
    }

    public static int fibonacci(int n) {
        if (n == 1) {
            return 0;

        } else if (n == 2) {
            return fibonacci(n - 1) + 1;
        } else {
            return fibonacci(n - 2) + fibonacci(n - 1);
        }
    }

    //Проверка числа на простоту
    //Дано натуральное число n>1. Проверьте, является ли оно простым. Программа должна вывести слово YES,
    //если число простое и NO, если число составное.
    public static boolean isPrime(int n) {
        boolean prime = false;
        if (n == 2) {
            prime = true;
            return prime;
        } else if (n == 3) {
            prime = true;
            return prime;
        } else {
            for (int i = 2; i < Math.sqrt(n); i++) {
                if (n % i == 0 && isPrime(i)) {
                    prime = false;
                    break;
                } else {
                    prime = true;
                }
            }
        }
        return prime;
    }
}

