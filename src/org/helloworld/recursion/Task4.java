package org.helloworld.recursion;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(ackermann(5, 3));
    }

    //Функция Аккермана
    public static int ackermann(int m, int n) {
        int result = 0;
        if (m == 0) {
            result = n + 1;
            return result;
        }
        if (m > 0 && n == 0) {
            result = ackermann(m - 1, 1);
        }
        if (m > 0 && n > 0) {
            result = ackermann(m - 1, ackermann(m - 1, 1));
        }
        return result;
    }
}
