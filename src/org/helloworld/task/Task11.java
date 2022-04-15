package org.helloworld.task;

import java.util.Scanner;

public class Task11 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a, b;
        int c = 0;
        char d;
        System.out.println("Введите a");
        a = s.nextInt();
        System.out.println("Введите b");
        b = s.nextInt();
        do {
            System.out.println("Введите операцию");
            d = s.next().charAt(0);
        } while (d != '+' && d != '-' && d != '/' && d != '*'&&d!='^');
        switch (d) {
            case '+':
                c = a + b;
                break;
            case '-':
                c = a - b;
                break;
            case '/':
                c = a / b;
                break;
            case '*':
                c = a * b;
                break;
            case '^':
                c=power(a,b);
                break;
        }

        System.out.println("Результат:" + c);
    }

    public static int power(int arg1, int arg2) {
        int p=1;
        for (int i = 0; i <= arg2; i++) {
            p = p * arg1;
        }
        return p;
    }
}

