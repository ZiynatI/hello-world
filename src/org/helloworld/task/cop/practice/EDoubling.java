package org.helloworld.task.cop.practice;


/*E. Doubling
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

You are given an integer sequence 𝑎1,𝑎2,…,𝑎𝑛.
A sequence is nice if every element is exactly twice the previous one.
For example, [1,2,4,8], [3,6,12] and [7] are nice and [10,5] and [1,2,9,18] aren't.
You are allowed to remove some elements from the given sequence (possibly, none). However, you are not allowed to rearrange the elements.
What's the smallest amount of elements you have to remove from the sequence so that it becomes nice?
Input

The first line contains a single integer 𝑡(1≤𝑡≤3000) — the number of test cases.

The first line of each test case contains a single integer 𝑛(1≤𝑛≤3000) — the number of elements in the sequence.
The second line contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤106).
The sum of 𝑛 over all test cases doesn't exceed 3000.
Output

For each test case, print a single integer — the smallest amount of elements you have to remove from the sequence so that it becomes nice.
Example
Input

3
10
1 2 3 4 5 6 7 8 9 10
5
8 4 2 1 1
10
1 2 3 4 5 6 12 24 48 100

Output

6
4
5

*/

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EDoubling {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCases = Integer.parseInt(stdin.nextLine());
        while (testCases > 0) {
            int seqSize = Integer.parseInt(stdin.nextLine());
            List<Integer> input = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(isNiceSeq(input));
            testCases--;
        }
    }

    public static int isNiceSeq(List<Integer> input) {
        int maxOfTwice = 0;
        int countNums = 1;
        for (int i = 0; i < input.size(); i++) {
            int twice = input.get(i) * 2;
            int idxI = input.indexOf(twice);
            while (idxI != -1) {
                if (idxI < i) {
                    break;
                }
                countNums++;
                twice *= 2;
                idxI = input.indexOf(twice);
            }
            if (maxOfTwice < countNums) {
                maxOfTwice = countNums;
            }
            countNums = 1;
        }
        return input.size() - maxOfTwice;
    }
}
