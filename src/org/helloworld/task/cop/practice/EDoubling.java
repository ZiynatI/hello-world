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
The second line contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤10^6).
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

import java.util.*;
import java.util.stream.Collectors;

public class EDoubling {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCases = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCases; i++) {
            int listLength = Integer.parseInt(stdin.nextLine());
            List<Integer> input = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            System.out.println(countRemoves(input, listLength));
        }
    }

    public static int countRemoves(final List<Integer> input) {
        int numOfRemovingMax = 0;
        List<Integer> temp = new ArrayList<>(input);
        Set<Integer> checked = new HashSet<>();
        for (int i = temp.size() - 1; i >= 0; i--) {
            int numOfRemoving = 1;
            int num = temp.get(i);
            if (checked.add(num)) {
                while (num % 2 == 0 && temp.contains(num / 2)) {
                    num /= 2;
                    numOfRemoving++;
                    checked.add(num);
                }
            }
            temp.remove(i);
            if (numOfRemovingMax < numOfRemoving) {
                numOfRemovingMax = numOfRemoving;
            }
        }
        return input.size() - numOfRemovingMax;
    }
}
