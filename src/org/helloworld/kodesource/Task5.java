package org.helloworld.kodesource;

import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        /* Напишите программу Java, которая принимает два числа в качестве входных данных
         и отображает произведение двух чисел.*/
        Scanner s = new Scanner(System.in);
        System.out.println("Введите второе число");
        int firstnumber = s.nextInt();
        System.out.println("Введите первое число");
        int secondnumber = s.nextInt();
        int result = firstnumber * secondnumber;
        System.out.println("Сумма = " + result);
    }
}
