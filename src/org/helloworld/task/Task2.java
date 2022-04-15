package org.helloworld.task;

public class Task2 {

    public static void main(String[] args) {
        final int desiredWidth = 9;
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j <= 15; j++) {
                int mul = (i * j);
                final String s = i + "x" + j + "=" + mul;
                System.out.print(s + " ");
                int numOfSpaces = desiredWidth - s.length();
                for (int k = 0; k < numOfSpaces; k++) {
                    System.out.print("_");
                }
            }
            System.out.println();
        }
    }

    //
}