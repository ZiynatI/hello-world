package org.helloworld.kodesource;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        //Напишите программу на Java, чтобы разделить два числа и напечатать на экране.
        Scanner s = new Scanner(System.in);
        System.out.println("Введите второе число");
        int firstnumber = s.nextInt();
        System.out.println("Введите первое число");
        int secondnumber = s.nextInt();
        int result = firstnumber / secondnumber;
        System.out.println("Результат = " + result);
    }
}
