package org.helloworld.task.cop.practice;

/*G. Red and Blue
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output
You are given an array 𝑎 of positive integers of length 𝑛. Initially, all elements of the array are colored blue.
You can perform the following operation any number of times (possibly zero):
take any blue element of the array 𝑥 and remove it, and instead insert two non-negative red integers,
the sum of which is equal to 𝑥(the elements are inserted in the same position; the order of the elements you insert may be arbitrary).
Your task is to determine if it is possible to sort the array 𝑎 in non-decreasing order applying
the aforementioned operation (i.e. transform 𝑎 so that 𝑎1≤𝑎2≤⋯≤𝑎𝑚, where 𝑚 is the length of the array after applying all operations).

Input
The first line contains a single integer 𝑡 (1≤𝑡≤1000) — the number of test cases.
The first line of each test case contains a single integer 𝑛 (1≤𝑛≤100) — the length of the array 𝑎.
The second line contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤100) — the array 𝑎 itself.

Output
For each test case, print YES if it is possible to sort the array 𝑎 in non-decreasing order applying the aforementioned operation;
otherwise print NO. You may print each letter in any case (YES, yes, Yes will all be recognized as positive answer,
NO, no and nO will all be recognized as negative answer).
Example
Input

4
2
4 3
4
1 3 3 7
3
5 5 4
6
2 4 5 3 8 6

Output

YES
YES
NO
YES

Note
In the first example, you can proceed as follows: split 4 into 1 and 3, then the array becomes [1,3,3].
In the second example, the array is already sorted.
In the third example, there is no way to make the array sorted.
In the first example, you can proceed as follows: split 5 into 2 and 3, then the array becomes [2,4,2,3,3,8,6];
split 8 into 3 and 5, then the array becomes [2,4,2,3,3,3,5,6];
split 4 into 2 and 2, then the array becomes [2,2,2,2,3,3,3,5,6].
*/

import java.util.Arrays;
import java.util.Scanner;

public class GRedAndBlue {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCasesNum = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCasesNum; i++) {
            stdin.nextLine();
            int[] nums = Arrays.stream(stdin.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.out.println(splitArray(nums) ? "YES" : "NO");
        }
    }

    private static boolean splitArray(int[] nums) {
        int previous = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            int current = nums[i];
            if (current > previous) {
                // Split it in halves
                int smallerHalf = current / 2;
                int biggerHalf = current % 2 == 0 ? smallerHalf : smallerHalf + 1;
                if (biggerHalf > previous) {
                    return false;
                }
                previous = smallerHalf;
            } else {
                // Do not split
                previous = current;
            }
        }
        return true;
    }
}
