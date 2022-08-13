package org.helloworld.demo;

import java.util.Arrays;

public class MergeSortDemo {
    public static void main(String[] args) {
        int[] output = new int[8];
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6, 8};
        int i = 0;
        int j = 0;
        for (int k = 0; k < output.length; k++) {
            if (a[i] < b[j]) {
                output[k] = a[i];
                i++;
            } else {
                output[k] = b[j];
                j++;
            }
        }
        System.out.println(Arrays.toString(output));
    }
}
