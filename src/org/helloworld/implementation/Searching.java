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

    public static int binarySearchIterative(int[] array, int arg) {
        int startIdx = 0;
        int endIdx = array.length - 1;
        while (startIdx <= endIdx) {
            int midIdx = (endIdx + startIdx) / 2;
            if (array[midIdx] == arg) {
                return midIdx;
            } else if (array[midIdx] < arg) {
                endIdx = midIdx - 1;
            } else if (array[midIdx] > arg) {
                startIdx = midIdx + 1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] array, int arg, int startIdx, int endIdx) {
        if (startIdx == endIdx) {
            return (array[startIdx] == arg) ? startIdx : -1;
        }
        if (startIdx > endIdx) {
            return -1;
        }
        int midIdx = startIdx + (endIdx - startIdx) / 2;
        if (array[midIdx] < arg) {
            return binarySearchRecursive(array, arg, midIdx + 1, endIdx);
        }
        if (array[midIdx] > arg) {
            return binarySearchRecursive(array, arg, startIdx, midIdx - 1);
        }
        return -1;
    }




}
