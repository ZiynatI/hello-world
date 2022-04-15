package org.helloworld.task;

public class Task1 {

    public static void main(String[] args) {
        int x = 98;
        int y = 2;
        int z = subtract(x, y);
        System.out.println(z);
    }

    public static int subtract(int arg1, int arg2) {
        return arg1 - arg2;
    }
}