package org.helloworld.task.cop.practice;

/*H. Reverse
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output
You are given an integer array 𝑎 of size 𝑛. Initially, the 𝑖-th element of the array is equal to 𝑖 (i.e 𝑎𝑖=𝑖).
You have to perform 𝑚 operations in the order they are given.
The operations have the following form: reverse the subarray (continuous subsegment) of 𝑎 from the 𝑙𝑖-th position to the 𝑟𝑖-th position (both endpoints inclusive).
You are given 𝑞 indices 𝑏1,𝑏2,…,𝑏𝑞. For each index 𝑏𝑖, print the value of 𝑎𝑏𝑖 after performing all the given operations.
Input
The first line contains three integers 𝑛, 𝑚 and 𝑞 (1≤𝑛≤106; 1≤𝑚≤105; 1≤𝑞≤20) — the size of the array, the number of operations and the number of indices.
The 𝑖-th of the following 𝑚 lines contains two integers 𝑙𝑖 and 𝑟𝑖 (1≤𝑙𝑖≤𝑟𝑖≤𝑛) — the borders of the subarray in the 𝑖-th operation.
The last line contains 𝑞 integers 𝑏1,𝑏2,…,𝑏𝑞 (1≤𝑏𝑖≤𝑛).
Output
Print 𝑞 integers — for each given index 𝑏𝑖, print the value of 𝑎𝑏𝑖 after performing all the given operations.
Examples
Input

5 2 5
2 4
3 5
5 4 3 2 1

Output

3 2 5 4 1

Input

4 4 5
2 3
1 4
2 3
4 4
1 3 4 2 3

Output

4 2 1 3 2
*/

import java.util.Scanner;

public class HReverse {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        String[] firstLine = stdin.nextLine().split(" ");
        int sizeOfArray = Integer.parseInt(firstLine[0]);
        int numOperations = Integer.parseInt(firstLine[1]);
        int numInd = Integer.parseInt(firstLine[2]);
        int[][] operations = new int[numOperations][2];
        for (int i = 0; i < numOperations; i++) {
            String[] op = stdin.nextLine().split(" ");
            operations[i][0] = Integer.parseInt(op[0]);
            operations[i][1] = Integer.parseInt(op[1]);
        }
        String[] indexesForPrintingst = stdin.nextLine().split(" ");
        int[] indexesForPrinting = new int[numInd];
        for (int i = 0; i < numInd; i++) {
            indexesForPrinting[i] = Integer.parseInt(indexesForPrintingst[i]);
        }
        printArray(performOperations(sizeOfArray, operations), indexesForPrinting);
    }

    public static int[] performOperations(int sizeOfArray, int[][] operations) {
        int[] arr = new int[sizeOfArray + 1];
        for (int i = 0; i <= sizeOfArray; i++) {
            arr[i] = i;
        }
        for (int[] operation : operations) {
            int end = operation[1];
            int start = operation[0];
            while (end > start) {
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
                end--;
                start++;
            }
        }
        return arr;
    }

    public static void printArray(int[] arr, int[] indexesForPrinting) {
        for (int i = 0; i < indexesForPrinting.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(arr[indexesForPrinting[i]]);
        }
    }
}
