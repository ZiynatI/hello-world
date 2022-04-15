package org.helloworld.task;

import java.util.Scanner;

public class Task12 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a;
        int b;
        System.out.println("Введите число от 1 до 100");
        a = (int) (Math.random() * 100 + 1);
        do {
            System.out.println("Угадайте число");
            b = s.nextInt();
            if (a > b) {
                System.out.println("Ваше число меньше");
            } else if (a < b) {
                System.out.println("Ваше число больше");
            } else if (a == b) {
                System.out.println("Угадали \uD83D\uDC4D");
            }
        } while (a != b);


    }
}
