package org.helloworld.kodesource;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        //Напишите программу на Java для вывода суммы двух чисел.
        Scanner s = new Scanner(System.in);
        System.out.println("Введите второе число");
        int firstnumber = s.nextInt();
        System.out.println("Введите первое число");
        int secondnumber = s.nextInt();
        int sum = firstnumber + secondnumber;
        System.out.println("Сумма = " + sum);
    }
}
