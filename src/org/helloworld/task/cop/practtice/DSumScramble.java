package org.helloworld.task.cop.practtice;
//time limit per test
//2 seconds
//memory limit per test
//256 megabytes
//input
//standard input
//output
//standard output
//There was a sequence of 𝑛
//integers 𝑎1,𝑎2,…,𝑎𝑛. From it, another sequence 𝑏1,𝑏2,…,𝑏𝑛 was constructed: 𝑏𝑖 equals the sum of digits in 𝑎𝑖.
//Two sequences were merged together and shuffled. The result is a sequence 𝑐1,𝑐2,…,𝑐2𝑛.
//You are given the sequence 𝑐 .Find any possible initial sequence 𝑎.
//If there are multiple answers, print any of them.
//Input
//The first line contains a single integer 𝑡
//(1≤𝑡≤100) — the number of test cases.
//The first line of each test case contains a single integer 𝑛
//(1≤𝑛≤100) — the number of elements in 𝑎.
//The second line contains 2𝑛
//integers 𝑐1,𝑐2,…,𝑐2𝑛 (1≤𝑐𝑖≤109).
//The tests are constructed in such a way that there exists a sequence 𝑎
//that can produce the given sequence 𝑐.
//Output
//For each test case, print 𝑛
//integers — the elements of the sequence 𝑎 such that it can produce the given sequence 𝑐.
//If there are multiple answers, print any of them.
//Example:
//Input:
//3
//2
//6 78456 1005 30
//1
//1 1000000000
//6
//7831 6642 10 19 17 9649 13 5714 1516 28 18 5203
//Output:
//1005 78456
//1000000000
//6642 5714 1516 5203 9649 7831

import java.util.Arrays;
import java.util.Scanner;

public class DSumScramble {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCases = Integer.parseInt(stdin.nextLine());
        while (testCases > 0) {
            findInitialSequence(stdin);
            testCases--;
        }
    }

    public static void findInitialSequence(Scanner stdin) {
        int seqSize = Integer.parseInt(stdin.nextLine());
        int[] seq = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        int[] sums = new int[seqSize * 2];
        for (int i = 0; i < seq.length; i++) {
            sums[i] = sumDigits(seq[i]);
        }
        int idx = 0;
        int[] seq2 = new int[seqSize];
        while (idx != seqSize) {
            outterLoop:
            for (int i = 0; i < seq.length; i++) {
                if (seq[i] == 0) {
                } else {
                    for (int j = seq.length - 1; j > i; j--) {
                        if (seq[j] == 0) {
                        } else {
                            if ((seq[j] == sums[i]) || (seq[i] == sums[j])) {
                                seq2[idx] = seq[i] > seq[j] ? seq[i] : seq[j];
                                seq[j] = 0;
                                seq[i] = 0;
                                idx++;
                                break outterLoop;
                            }

                        }
                    }
                }
            }
        }
        printArr(seq2);
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static int sumDigits(int n) {
        int num = n;
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = (num - num % 10) / 10;
        }
        return sum;
    }
}
