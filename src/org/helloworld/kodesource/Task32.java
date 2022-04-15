package org.helloworld.kodesource;

import java.util.Scanner;

public class Task32 {
    public static void main(String[] args) {
        //Напишите программу на Java для сравнения двух чисел.
        Scanner s = new Scanner(System.in);
        System.out.println("");
        int first = s.nextInt();
        System.out.println("");
        int second = s.nextInt();
        if (first == second) {
            System.out.println("first == second");}
        else{
                System.out.println("first != second");
            }

        }
    }
