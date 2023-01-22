package org.helloworld.implementation;

public class Searching {
    public static int linearSearch(int[] array, int arg) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == arg) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int arg) {
        boolean found = false;
        int idx;
        while (!found) {
            int i = array.length / 2;
            if (array[i] == arg) {
                idx = i;
                found = true;
            } else if (array[i] > arg) {
            }
        }
    }
}
