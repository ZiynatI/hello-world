package org.helloworld.task.cop;

/*F. XO Game
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output
Alice and Bob are playing a game. They have a string 𝑠 consisting of characters X and O. Players take turns, Alice is first.
During their move, the player chooses two adjacent characters of the string and swaps them
(it is obligatory to do this, so the players cannot skip their turn; but it is allowed to choose two equal characters if they are adjacent).
Alice wins the game if, after someone's move, the string contains at least three consecutive characters X.
Bob wins the game if, after someone's move, the string contains at least three consecutive characters O.
If XXX and OOO occur at the same time, the player who made the last move wins. If the game lasts for 1337 turns and nobody wins, it ends in a tie.
Your task is to determine the result of the game if both players play optimally.

Input
The first line contains a single integer 𝑡(1≤𝑡≤500) — the number of test cases.
The only line of each test case contains a string 𝑠(3≤|𝑠|≤300), consisting of characters X and O.
Additional constraint on the input: among every three consecutive characters in 𝑠, there is at least one X and at least one O.

Output
For each test case, print the result of the game if both players play optimally.
If Alice wins, print "Alice". If Bob wins, print "Bob". If it's a tie, print "Tie".

Example
Input

4
XOXXO
OOXOX
OOXOXOXO
XOXOX

Output

Alice
Tie
Bob
Tie


Note

In the first example, in order to win, Alice can swap 1
-st and 2

-nd characters, so the string becomes equal to OXXXO.

In the third example, let's consider all possible Alice's first moves and Bob's responses:

    swap 1

-st and 2-nd characters (the string becomes OOXOXOXO), in this case Bob swaps 3-rd and 4
-th characters (the string becomes OOOXXOXO) and wins;
swap 2
-nd and 3-rd characters (the string becomes OXOOXOXO), in this case Bob swaps 1-st and 2
-nd characters (the string becomes XOOOXOXO) and wins;
swap 3
-rd and 4
-th characters (the string becomes OOOXXOXO), there are three consecutive O, so Bob wins;
swap 4
-th and 5-th characters (the string becomes OOXXOOXO), in this case Bob swaps 7-th and 8
-th characters (the string becomes OOXXOOOX) and wins;
swap 5
-th and 6-th characters (the string becomes OOXOOXXO), in this case Bob swaps 2-nd and 3
-rd characters (the string becomes OXOOOXXO) and wins;
swap 6
-th and 7-th characters (the string becomes OOXOXXOO), in this case Bob swaps 3-rd and 4
-th characters (the string becomes OOOXXXOO), there are three consecutive X and three consecutive O, but the last move is Bob's move, so he wins;
swap 7
-th and 8-th characters (the string becomes OOXOXOOX), in this case Bob swaps 4-th and 5-th characters (the string becomes OOXXOOOX) and wins.
*/
public class FXOGame {
}
