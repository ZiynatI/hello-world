package org.helloworld.implementation;

import java.util.Arrays;

//внешний цикл - [min; max), внутренний - (min; max]
//quick - основная
//merge - важно для понимания рекурсивных алгоритмов, используется редко
//квадратичные достаточно знать парочку любых, на практике почти не используются
public class Sorting {
    public static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    /**
     * <p>Best sort ascending<p>
     * <p>Average sort ascending
     * <p>Worst sort ascending
     * <p>Memory
     */
    public static void main(String[] args) {
        int[] array = new int[]{5, 2, 1, 3, 9, 0, 4, 6, 8, 7};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        int[] array2 = new int[]{5, 2, 1, 3, 9, 0, 4, 6, 8, 7};
        mergeSort(array2);
        System.out.println(Arrays.toString(array2));
    }


    /**
     * @ Best sort ascending n
     * @ Average sort ascending n^2
     * @ Worst sort ascending n^2
     * @ Memory 1
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }


    /**
     * Cocktail sort
     *
     * @ Best sort ascending n
     * @ Average sort ascending n^2
     * @ Worst sort ascending n^2
     * @ Memory 1
     */
    public static void bidirectionalBubbleSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        do {
            for (int i = begin; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
            end--;
            for (int i = end; i > begin; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i - 1, i);
                }

            }
            begin++;
        } while (begin < end);
    }


    /**
     * @ Best sort ascending nlogn
     * @ Average sort ascending n^2
     * @ Worst sort ascending n^2
     * @ Memory 1
     */
    public static void combSort(int[] array) {
        int begin = 0;
        int end = array.length - 1;
        while (end > 0) {
            for (int i = end; i < array.length; i++) {
                if (array[begin] > array[i]) {
                    swap(array, i, begin);
                }
                begin++;
            }
            end--;
            begin = 0;
        }
    }


    /**
     * GnomeSort (Bubble+Insertion)
     *
     * @ Best sort ascending n
     * @ Average sort ascending n^2
     * @ Worst sort ascending n^2
     * @ Memory 1
     */
    public static void gnomeSort(int[] array) {
        int counter = 1;
        while (counter < array.length) {
            if (array[counter] < array[counter - 1]) {
                for (int i = counter; i > 0; i--) {
                    if (array[i] < array[i - 1]) {
                        swap(array, i - 1, i);
                    } else {
                        break;
                    }
                }
            }
            counter++;
        }
    }


    /**
     * @ Best sort ascending n
     * @ Average sort ascending n^2
     * @ Worst sort ascending n^2
     * @ Memory 1
     */
    public static void oddEvenSort(int[] array) {

    }


    /**
     * @ Best sort ascending n^2
     * @ Average sort ascending n^2
     * @ Worst sort ascending n^2
     * @ Memory 1
     */
    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int minIndex = i;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                swap(array, i, minIndex);
            }
        }
    }


    /**
     * @ Best sort ascending nlogn
     * @ Average sort ascending nlogn
     * @ Worst sort ascending n^2
     * @ Memory logn
     */
    public static void quickSort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int startInx, int endInx) {
        if (endInx - startInx <= 1) {
            return;
        } else {
            int wall = startInx;
            for (int i = startInx; i < endInx; i++) {
                if (array[i] < array[endInx]) {
                    swap(array, i, wall);
                    wall++;
                }
            }
            if (array[endInx] < array[wall]) {
                swap(array, wall, endInx);
            }
            if (wall - startInx > 1) {
                quicksort(array, startInx, wall - 1);

            }
            if (endInx - wall > 0) {
                quicksort(array, wall + 1, endInx);
            }
        }
    }

    /**
     * @ Best sort ascending nlogn
     * @ Average sort ascending nlogn
     * @ Worst sort ascending nlogn
     * @ Memory n
     */
    public static void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int startIdx, int endIdx) {
        if (endIdx - startIdx == 0) {
            return;
        } else {
            int midIdx = startIdx + (endIdx - startIdx) / 2;
            mergeSort(array, startIdx, midIdx);
            mergeSort(array, midIdx + 1, endIdx);
            merge(array, startIdx, endIdx);
        }
    }

    private static void merge(int[] array, int startIdx, int endIdx) {
        int firstSubArrInx = startIdx;
        int midIdx = ((endIdx - startIdx) / 2) + startIdx;
        int secondSubArrInx = midIdx + 1;
        int[] buffer = new int[endIdx - startIdx + 1];
        for (int i = 0; i < buffer.length; i++) {
            if (firstSubArrInx == midIdx + 1) {
                buffer[i] = array[secondSubArrInx];
                secondSubArrInx++;
            } else if (secondSubArrInx == endIdx + 1) {
                buffer[i] = array[firstSubArrInx];
                firstSubArrInx++;
            } else {
                if (array[firstSubArrInx] < array[secondSubArrInx]) {
                    buffer[i] = array[firstSubArrInx];
                    firstSubArrInx++;
                } else {
                    buffer[i] = array[secondSubArrInx];
                    secondSubArrInx++;
                }
            }
        }
        for (int i = startIdx; i <= endIdx; i++) {
            array[i] = buffer[i - startIdx];
        }
    }
}
