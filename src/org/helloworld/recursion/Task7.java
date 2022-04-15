package org.helloworld.recursion;

public class Task7 {
    public static void main(String[] args) {
        System.out.println(fromLastToFirst(68418));
        System.out.println(inverse(7));
        System.out.println(inverse(68));
        System.out.println(inverse(123));
        System.out.println(inverse(76598865));
        System.out.println(countDigits(123));
    }

    //    Цифры числа справа налево
    //    Дано натуральное число N. Выведите все его цифры по одной, в обратном порядке, разделяя их пробелами или новыми строками.
    //    При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется). Разрешена только рекурсия и целочисленная арифметика.
    public static String fromLastToFirst(int n) {
        if (n < 10) {
            return String.valueOf(n);
        }
        return String.valueOf(n % 10) + " " + fromLastToFirst(n / 10);
    }

    // Возвращает число задом наперёд
    public static int inverse(int n) {
        if (n < 10) {
            return n;
        }
        int p = countDigits(n);
        return (inverse(n / 10) + (n % 10) * ((int) Math.pow(10, p--)));
    }

    public static int countDigits(int n) {
        int p = 0;
        do {
            n = n / 10;
            p++;
        } while (n > 10);
        return p;
    }
}
