package org.helloworld.kodesource;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        //Напишите программу на Java, которая принимает три числа в качестве входных данных для вычисления и печати среднего числа.
        Scanner s = new Scanner(System.in);
        System.out.println("Введите первое число");
        double a = s.nextInt();
        System.out.println("Введите второе число");
        double b = s.nextInt();
        System.out.println("Введите третье число");
        double c = s.nextInt();
        double average = (a+b+c)/3;
        System.out.println(average);
    }
}
