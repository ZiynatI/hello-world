package org.helloworld.kodesource;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        //Напишите Java-программу для печати области и периметра круга.
        Scanner s = new Scanner(System.in);
        double radius = s.nextDouble();
        double area=3.1415*3.1415*radius;
        double circumference=2*3.1415*radius;
        System.out.println(area);
        System.out.println(circumference);

    }
}
