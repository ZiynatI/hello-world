package org.helloworld.task;

public class Task5 {
    public static void main(String[] args) {
        int mul;
        int sum = 0;
        int[] arr = new int[]{4, 1, 3, 1, 9, 5, 6, 150, 3, 7, 1, 9, 1};
        for (int i = 0; i < arr.length - 1; i = i + 2) {
            mul = arr[i] * arr[i + 1];
            sum = sum + mul;
        }
        System.out.println(sum);
    }
}

