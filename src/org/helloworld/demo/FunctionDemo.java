package org.helloworld.demo;

import java.util.Arrays;

public class FunctionDemo {
    public static void main(String[] args) {
        int[] x = {3, 5, 7, 29, 8, 0, 3, 2};
        int[] y = x;
        y = new int[]{333, 5, 7, 29, 8, 0, 3, 2};
//        sort(x);
        System.out.println(Arrays.toString(x));
    }

    /**
     * Sort the array
     */
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
