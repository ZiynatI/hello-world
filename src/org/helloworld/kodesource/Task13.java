package org.helloworld.kodesource;

import java.util.Scanner;

public class Task13 {
    public static void main(String[] args) {
        //Напишите Java-программу для печати площади и периметра прямоугольника.
        Scanner s = new Scanner(System.in);
        System.out.println("Введите длину прямоугольника");
        double a = s.nextDouble();
        System.out.println("Введите ширину прямоугольника");
        double b = s. nextDouble();
        double area = a*b;
        double perimeter = (a+b)*2;
        System.out.println(area);
        System.out.println(perimeter);
    }
}
