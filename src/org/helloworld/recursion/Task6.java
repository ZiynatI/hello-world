package org.helloworld.recursion;

public class Task6 {
    public static void main(String[] args) {
        System.out.println(countDigitsSum(687486613));
    }

    //Сумма цифр числа
    //Дано натуральное число N. Вычислите сумму его цифр.
    //При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
    public static int countDigitsSum(int n) {
        if (n < 10) {
            return n;
        }
        return n % 10 + countDigitsSum((n - n % 10) / 10);
    }
}
