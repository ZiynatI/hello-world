package org.helloworld.task.cop.practice;
/*D. Sum Scramble
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

There was a sequence of 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛. From it, another sequence 𝑏1,𝑏2,…,𝑏𝑛 was constructed: 𝑏𝑖 equals the sum of digits in 𝑎𝑖.
Two sequences were merged together and shuffled. The result is a sequence 𝑐1,𝑐2,…,𝑐2𝑛.
You are given the sequence 𝑐. Find any possible initial sequence 𝑎.
If there are multiple answers, print any of them.
Input
The first line contains a single integer 𝑡(1≤𝑡≤100) — the number of test cases.
The first line of each test case contains a single integer 𝑛 (1≤𝑛≤100) — the number of elements in 𝑎.
The second line contains 2𝑛 integers 𝑐1,𝑐2,…,𝑐2𝑛 (1≤𝑐𝑖≤109).
The tests are constructed in such a way that there exists a sequence 𝑎 that can produce the given sequence 𝑐.

Output
For each test case, print 𝑛 integers — the elements of the sequence 𝑎 such that it can produce the given sequence 𝑐.
If there are multiple answers, print any of them.
Example
Input

3
2
6 78456 1005 30
1
1 1000000000
6
7831 6642 10 19 17 9649 13 5714 1516 28 18 5203

Output

1005 78456
1000000000
6642 5714 1516 5203 9649 7831
*/

import java.util.*;
import java.util.stream.Collectors;

public class DSumScramble {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCases = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCases; i++) {
            stdin.nextLine(); // We don't need seq size.
            List<Integer> input = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
            printArr(findInitialSequence(input));
        }
    }

    public static List<Integer> findInitialSequence(List<Integer> input) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        List<Integer> list = new ArrayList<>();
        pq.addAll(input);
        while (!pq.isEmpty()) {
            int currentEl = pq.peek();
            list.add(currentEl);
            pq.remove(currentEl);
            pq.remove(sumDigits(currentEl));
        }
        return list;
    }

    private static void printArr(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(list.get(i));
        }
        System.out.println();
    }

    private static int sumDigits(int n) {
        int num = n;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = (num - num % 10) / 10;
        }
        return sum;
    }
}
