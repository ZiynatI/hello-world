package org.helloworld.task.cop.practtice;


//time limit per test
//2 seconds
//memory limit per test
//256 megabytes
//input
//standard input
//output
//standard output
//
//You are given an integer sequence 𝑎1,𝑎2,…,𝑎𝑛
//
//.
//
//A sequence is nice if every element is exactly twice the previous one. For example, [1,2,4,8]
//, [3,6,12] and [7] are nice and [10,5] and [1,2,9,18]
//
//aren't.
//
//You are allowed to remove some elements from the given sequence (possibly, none). However, you are not allowed to rearrange the elements.
//
//What's the smallest amount of elements you have to remove from the sequence so that it becomes nice?
//Input
//
//The first line contains a single integer 𝑡
//(1≤𝑡≤3000
//
//) — the number of test cases.
//
//The first line of each test case contains a single integer 𝑛
//(1≤𝑛≤3000
//
//) — the number of elements in the sequence.
//
//The second line contains 𝑛
//integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤106
//
//).
//
//The sum of 𝑛
//over all test cases doesn't exceed 3000
//
//.
//Output
//
//For each test case, print a single integer — the smallest amount of elements you have to remove from the sequence so that it becomes nice.
//Example
//Input
//Copy
//
//3
//10
//1 2 3 4 5 6 7 8 9 10
//5
//8 4 2 1 1
//10
//1 2 3 4 5 6 12 24 48 100
//
//Output
//Copy
//
//6
//4
//5

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EDoubling {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCases = Integer.parseInt(stdin.nextLine());
        while (testCases > 0) {
            isNiceSeq(stdin);
            testCases--;
        }
    }

    public static void isNiceSeq(Scanner stdin) {
        int seqSize = Integer.parseInt(stdin.nextLine());
        int[] seq = Arrays.stream(stdin.nextLine().split(" ")).map(Integer::parseInt).mapToInt(x -> x).toArray();
        List<Integer> list = Arrays.stream(seq).boxed().collect(Collectors.toList());
        int n = 1;
        int r = seqSize;
        int twice = 0;
        for (int i = 0; i < seqSize; i++) {
            n = 1;
            twice = seq[i];
            while (twice < seq[seq.length - 1]) {
                twice *= 2;
                if (list.contains(twice) && list.indexOf(twice) > i) {
                    n++;
                } else {
                    break;
                }
            }
            n = seqSize - n;
            if (n < r) {
                r = n;
            }
        }
        System.out.println(r);
    }
}
