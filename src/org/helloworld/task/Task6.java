package org.helloworld.task;

public class Task6 {

    public static void main(String[] args) {
        System.out.println(squareSum(new int[]{5, -3, 4}));
    }

    public static int squareSum(int[] n) {
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            int a = n[i] * n[i];
            sum = sum + a;
        }
        return sum;
    }
}
