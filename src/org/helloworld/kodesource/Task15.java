package org.helloworld.kodesource;

public class Task15 {
    public static void main(String[] args) {
        //Напишите программу на Java для замены двух переменных.
        int a = 30;
        int b = 40;
        int temp = 0;
        a = b;
        b = temp;
        temp = a;
        System.out.println("a=" + a);
        System.out.println("b=" + b);

        int a1 = 30;
        int b1 = 40;
        a1 = a1 + b1;
        b1 = a1 - b1;
        a1 = a1 - b1;
        System.out.println("a1=" + a1);
        System.out.println("b1=" + b1);
    }
}
