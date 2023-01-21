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
}
