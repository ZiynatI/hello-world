package org.helloworld.task.cop.practice;

/*J. Solid String
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

You are given a string s, consisting of letters 'X' and 'Y' in some order. A string is called solid if:
-it contains the same amount of letters 'X' and 'Y';
-none of its prefixes contain more letters 'Y' than 'X'.
The given string s is solid.
You can perform the following operation with s any number of times (possibly zero): choose two consecutive (i.e. the last character
of the first substring should be right before the first character of the second substring} solid contiguous substrings of s, and swap them.
It can be shown that the string s stays solid after such an operation.
What's the lexicographically smallest string you can obtain?

Input
The first line contains a single integer t (1≤t≤100) — the number of test cases.
The first line of each test case contains a single integer n (1≤n≤25).
The second line contains a string s (|s|=2·n), consisting of n letters 'X' and n letters 'Y' in some order.
Additional constraint on the input: the string s is solid.
Output

For each test case, print the lexicographically smallest string you can obtain after applying an arbitrary amount of operations to s (possibly, zero).
Example
Input


2
4
XXYXXYYY
1
XY

Output


XXXYYXYY
XY*/

import java.util.Scanner;

public class JSolidString {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCasesNum = Integer.parseInt(stdin.nextLine());

    }
}
