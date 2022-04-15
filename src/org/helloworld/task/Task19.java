package org.helloworld.task;

public class Task19 {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 4648, 4, 687, 48, 687, 687, 784, 7, 96, 698, 9};
        System.out.println(sortArray(arr));
    }

    //Сделать функцию, которая сортирует массив по возрастанию.
    public static int[] sortArray(int[] ar) {
        for (int i = 0; i < ar.length; i++) {

            for (int j = 0; j < ar.length-1; j++) {
                if (ar[j] > ar[j + 1]) {
                    int temp = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = temp;
                }
            }
        }
        return ar;
    }
}
