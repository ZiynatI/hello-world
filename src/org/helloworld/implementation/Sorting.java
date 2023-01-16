package org.helloworld.implementation;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 1, 3, 9, 0, 4, 6, 8, 7};
        combSort(array);
        System.out.println(Arrays.toString(array));
        int[] array2 = new int[]{5, 2, 1, 3, 9, 0, 4, 6, 8, 7};
        insertionSort(array2);
        System.out.println(Arrays.toString(array2));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void bidirectionalBubbleSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        do {
            for (int i = begin; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
            end--;
            for (int i = end; i > begin; i--) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                }

            }
            begin++;
        } while (begin < end);
    }

    public static void combSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        while (end > 0) {
            for (int i = end; i < array.length; i++) {
                if (array[begin] > array[i]) {
                    int temp = array[i];
                    array[i] = array[begin];
                    array[begin] = temp;
                }
                begin++;
            }
            end--;
            begin = 0;
        }
    }

    public static void insertionSort(int[] array) {
        int counter = 1;
        while (counter < array.length) {
            if (array[counter] < array[counter - 1]) {
                for (int i = counter; i > 0; i--) {
                    if (array[i] < array[i - 1]) {
                        int temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                    } else {
                        break;
                    }
                }
            }
            counter++;
        }
    }

    public static void quicksort(int[] array){

    }
    
}
