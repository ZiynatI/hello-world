package org.helloworld.kodesource;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        //Напишите Java-программу для печати суммы (сложения), умножения, вычитания, деления и остатка двух чисел.
        Scanner s = new Scanner(System.in);
        System.out.println("Введите второе число");
        int firstnumber = s.nextInt();
        System.out.println("Введите первое число");
        int secondnumber = s.nextInt();
        System.out.println(firstnumber+"+"+secondnumber+"="+firstnumber+secondnumber);
        System.out.println(firstnumber+"*"+secondnumber+"="+firstnumber*secondnumber);
        System.out.println(firstnumber+"/"+secondnumber+"="+firstnumber/secondnumber);
        System.out.println(firstnumber+"%"+secondnumber+"="+firstnumber*secondnumber);
    }
}
