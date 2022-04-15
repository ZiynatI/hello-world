package org.helloworld.task;

public class Task8 {
    public static void main(String[] args) {
        int a = 1236547 ;
        System.out.println();
        System.out.println(reflection(a));
    }

    public static int reflection(int arg) {
        int c = arg % 10;
        do {
            arg = arg / 10;
            c = c * 10 + arg % 10;
        } while (arg > 1);
        return c;
    }
}
