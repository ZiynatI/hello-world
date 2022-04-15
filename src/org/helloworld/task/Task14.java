package org.helloworld.task;

import java.util.Scanner;

public class Task14 {
    //Напишите программу на Java, которая принимает целое число (n) и вычисляет значение n + nn + nnn
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        final long n = s.nextLong();

        int numberOfDigits = 0;
        long temp1 = n;
        do {
            temp1 = temp1 / 10;
            numberOfDigits++;
        } while (temp1 > 0);

        long nn = n;
        for (int i = 1; i <= numberOfDigits; i++) {
            nn = nn * 10;
        }
        nn = nn + n;

        long nnn = nn;
        for (int i = 1; i <= numberOfDigits; i++) {
            nnn = nnn * 10;
        }
        nnn = nnn + n;

        long sum = n + nn + nnn;
        System.out.println(sum);
    }
}
