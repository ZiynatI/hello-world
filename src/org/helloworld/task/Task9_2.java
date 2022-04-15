package org.helloworld.task;

public class Task9_2 {
    public static void main(String[] args) {
        System.out.println(countWhites(5, 6));
        System.out.println(countWhites(1, 1));
        System.out.println(countWhites(1, 2));
        System.out.println(countWhites(2, 1));
        System.out.println(countWhites(2, 2));
        System.out.println(countWhites(3, 2));
        System.out.println(countWhites(3, 3));
        System.out.println(countWhites(5, 6));
    }

    public static int countWhites(int arg1, int arg2) {
        int whites = 0;
        for (int i = 0; i <= arg1 * arg2; i++) {
            for (int j = 0; j <= arg1 * arg2; j = j + 2) {

            }
        }

        return whites;
    }
}
