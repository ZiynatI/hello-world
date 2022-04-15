package org.helloworld.task;

public class Task9 {
    public static void main(String[] args) {
        System.out.println(countWhites(1, 1));
        System.out.println(countWhites(1, 2));
        System.out.println(countWhites(2, 1));
        System.out.println(countWhites(2, 2));
        System.out.println(countWhites(3, 2));
        System.out.println(countWhites(3, 3));
        System.out.println(countWhites(5, 6));
        System.out.println(countWhites(46598,546464));

    }

    public static int countWhites(int arg1, int arg2) {
        int a = 0;
        if ((arg1 * arg2) % 2 == 0) {
            a = (arg1 * arg2) / 2;
        } else if ((arg1 * arg2 % 2) == 1) {
            a = (arg1 * arg2) / 2 + 1;
        }
        return a;
    }
}
