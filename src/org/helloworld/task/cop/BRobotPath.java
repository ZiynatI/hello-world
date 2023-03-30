package org.helloworld.task.cop;



/*B. Robot Path
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output
There is an infinite 2 -dimensional grid. Initially, the robot stands in the cell (0,0). The robot can execute four commands:
    U — move one cell up;
    D — move one cell down;
    L — move one cell left;
    R — move one cell right.
Let's call two sequences of commands equal if the robot ends up in the same cell using both of the sequences.
You are given a sequence of commands 𝑠. Your task is to calculate the minimum possible length of a sequence that is equal to 𝑠.

Input
The first line contains a single integer 𝑡(1≤𝑡≤1000) — the number of test cases.
The only line of each test case contains a string 𝑠(1≤|𝑠|≤100), consisting of characters L, R, U and D.

Output
For each test case, print a single integer — the minimum possible length of a sequence that is equal to 𝑠.
Example

Input
5
RURDR
DLUR
L
RULR
LDUUDDRR

Output
3
0
1
2
2
*/

import java.util.Scanner;

public class BRobotPath {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCasesNum = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCasesNum; i++) {
            String st = stdin.nextLine();
            System.out.println(countMoves(st));
        }
    }

    public static int countMoves(String st) {
        int hor = 0;
        int ver = 0;
        for (int i = 0; i < st.length(); i++) {
            if (st.charAt(i) == 'R') {
                hor++;
            } else if (st.charAt(i) == 'L') {
                hor--;
            } else if (st.charAt(i) == 'U') {
                ver++;
            } else if (st.charAt(i) == 'D') {
                ver--;
            }
        }
        if (hor < 0) {
            hor *= -1;
        }
        if (ver < 0) {
            ver *= -1;
        }
        return hor + ver;
    }
}
