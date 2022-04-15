package org.helloworld.kodesource;

import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        /*Напишите программу на Java, которая принимает число в качестве входных данных и печатает свою таблицу
         умножения до 10.*/
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println(a+" * 1 = "+a*1);
        System.out.println(a+" * 2 = "+a*2);
        System.out.println(a+" * 3 = "+a*3);
        System.out.println(a+" * 4 = "+a*4);
        System.out.println(a+" * 5 = "+a*5);
        System.out.println(a+" * 6 = "+a*6);
        System.out.println(a+" * 7 = "+a*7);
        System.out.println(a+" * 8 = "+a*8);
        System.out.println(a+" * 9 = "+a*9);
        System.out.println(a+" * 10 = "+a*10);
    }
}
