package org.helloworld.recursion;

public class Task5 {
    public static void main(String[] args) {
        System.out.println(isPower(64));
    }

    //Точная степень двойки
    //Дано натуральное число N. Выведите слово YES, если число N является точной степенью двойки,
    //или слово NO в противном случае.
    public static boolean isPower(double n) {
        if (n == 2) {
            return true;
        } else if (n % 2 != 0) {
            return false;
        }
        return isPower(n / 2);
    }
}
