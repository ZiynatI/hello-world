package org.helloworld.task.cop.practice;
/*K. Split
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

Monocarp has once again found himself mindlessly browsing papers on arxiv.
Today he stumbled upon a classic one. Solving an NP-hard problem in linear time.
The problem was the following. Given a sequence of integers 𝑎1,𝑎2,…,𝑎𝑛, split it into two sequences
so that the absolute difference between the sums of the sequences is minimized.
The paper described a greedy approach. As long as there is more than one element in the sequence,
remove the two largest elements from it and insert their absolute difference into the sequence.
The only remaining element in the sequence at the end is the answer.
Surely, this algorithm is not exactly correct, but it's a decent approximation.
However, the paper only provided a way to find the difference, but didn't tell how to construct the answer itself. Apparently, that is left as an exercise for the reader.
As a diligent reader, Monocarp took the challenge of construction the answer upon himself. You just want to help him a little...
Find any split of the given sequence 𝑎 into two sequences so that the absolute difference between the sums of the sequences is exactly
the result of the algorithm. If there are multiple answers, you can print any of them.

Input
The first line contains a single integer 𝑛 (1≤𝑛≤2⋅105) — the length of the sequence.
The second line contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤109).

Output
The first line should contain a single integer 𝑑 — the answer given by the algorithm — the remaining element in the sequence.
The second line should contain the length of the first sequence 𝑛1 and 𝑛1 integers — the elements from 𝑎that should be in the first sequence.
The third line should contain the length of the second sequence 𝑛2 and 𝑛2 integers — the elements from 𝑎 that should be in the second sequence.
You can print the elements in any order. Every element from 𝑎 should belong to exactly one of the two sequences.
If there are multiple answers, you can print any of them.
Examples
Input

5
3 3 4 5 8

Output

1
2 4 8
3 3 3 5

Input

4
1 2 3 4

Output

0
2 2 3
2 1 4

Input

5
5 5 4 3 3

Output

2
3 3 3 5
2 4 5
*/


import java.util.*;

public class KSplit {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int seqLength = Integer.parseInt(stdin.nextLine());
        String[] seq = stdin.nextLine().split(" ");
        PriorityQueue<Integer> nums = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < seqLength; i++) {
            nums.add(Integer.parseInt(seq[i]));
        }
        splitSeq(nums);
    }

    public static void splitSeq(PriorityQueue<Integer> nums) {
        int onee = 0;
        int twoo = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        while (!nums.isEmpty()) {
            int num = nums.poll();
            if (onee <= twoo) {
                onee += num;
                list1.add(num);
            } else {
                twoo += num;
                list2.add(num);
            }
        }
        System.out.println(onee > twoo ? onee - twoo : twoo - onee);
        printArr(list1);
        printArr(list2);
    }

    public static void printArr(List<Integer> list) {
        System.out.print(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.print(" " + list.get(i));
        }
        System.out.println();
    }
}
