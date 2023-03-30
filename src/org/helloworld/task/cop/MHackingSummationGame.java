package org.helloworld.task.cop;
/*M. Hacking Summation Game
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

While browsing the Internet, you found one puzzle game. In this game, you are given 𝑛 cards with positive integers 𝑎1,𝑎2,…,𝑎𝑛 written on them.
You are playing against a computer by making moves in turn. You pick one card and place it in the initially empty row. After that, the computer places '+' or '-' sign after it. Then again, you place another card at the end of the row. After that, computer places a sign, and so on. No card can be used twice.
After you place the last 𝑛-th card, the game finishes, and you end up with an arithmetic expression that is calculated automatically.
If the result of the expression is equal to 0, then you lose, otherwise you win.
Since the game seemed hard, you decided to hack the game files and discovered that the computer has only 𝑘strategies to play, where the 𝑖-th strategy is just a string of 𝑛−1
'+' and/or '-' signs. So, in reality, the play style of the computer is easy: it chooses one of the strategies at random and places the signs according to that strategy, in order they appear in the string denoting that strategy.
So, knowing how the computer plays, you decided to create a counter-strategy to all its strategies, by choosing an order of cards you'll pick for each of 𝑘
computer strategies. Of course, you are planning to win as many games as you can, so you want to maximize the number of strategies chosen by the computer that you win against.
But there is one last problem: you don't know what strategy the computer is choosing at the start of the match, so you need to choose the orders of cards that are consistent with each other. In other words, if the first 𝑥
signs in strategies 𝑖 and 𝑗 are the same, you must choose counter-strategies in such a way that the first 𝑥+1
cards you pull and place are the same as well. If you don't do so, it may happen that you won't know what card to place next, since you are not sure which strategy the computer has chosen.
What is the maximum number of strategies you can win against if the chosen counter-strategies are consistent?
Input
The first line contains the single integer 𝑛(2≤𝑛≤200) — the number of cards you are given.
The second line contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤104) — the values written on the cards.
The third line contains the single integer 𝑘 (1≤𝑘≤1024) — the number of strategies the computer has.
The next 𝑘 lines contain descriptions of strategies — one per line. The 𝑖-th line contains a string 𝑠𝑖 consisting of 𝑛−1 characters, where each character is either '+' or '-'. The string 𝑠𝑖 describes which signs the computer will place and in what order if it chooses the 𝑖-th strategy.
Output
First, print one integer — the maximum number of strategies you can win against.
Next, print 𝑘 permutations 𝑝1,𝑝2,…,𝑝𝑘, where 𝑝𝑖 is the permutation of size 𝑛 and 𝑝𝑖 describes in what order you should place cards when playing against the 𝑖-th strategy.
Remember that all 𝑘 permutations must be consistent, i. e. if the first 𝑥 characters of the strategies 𝑖 and 𝑗 are equal, then the first 𝑥+1 values in permutations 𝑝𝑖 and 𝑝𝑗 must be equal as well. It also means that all 𝑘
permutations should start from the same value.
Examples
Input
4
3 1 7 3
4
++-
+++
+++
---

Output
4
1 4 3 2
1 4 3 2
1 4 3 2
1 2 3 4

Input
4
2 2 2 2
2
+--
++-

Output
1
1 2 4 3
1 2 3 4*/
public class MHackingSummationGame {
}
