package org.helloworld.task.cop;
/*J. Chocolate Fairness
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

𝑛 friends have bought 𝑘 identical chocolate bars (𝑘 bars in total, not 𝑘 bars per person), each one weighing 300 grams.
Now, they want to split them as evenly as possible among each other.
Each chocolate bar can be split the following ways:
    left in 1piece, weighing 300 grams;
    split into 2 pieces, each one weighing 150 grams;
    split into 3 pieces, each one weighing 100 grams.
The chocolate bars are split independently of each other.
After all 𝑘 chocolate bars are split, each of 𝑛 friends takes some of the resulting chocolate pieces.
All chocolate pieces should be distributed among the friends.
Let the unfairness value be the difference between the maximum and the minimum amount of chocolate each friend gets (the amount of chocolate a person gets is equal to the total weight of the pieces that person gets).
Consider the split with the smallest unfairness value over all splits. What is the smallest total number of chocolate pieces it can contain?

Input
The first line contains a single integer 𝑡 (1≤𝑡≤104) — the number of testcases.
The only line of each testcase contains two integers 𝑛 and 𝑘 (1≤𝑛,𝑘≤108) — the number of friends and the number of chocolate bars.

Output
For each testcase, print a single integer — the smallest total number of chocolate pieces a split with the smallest unfairness value can contain.
Example
Input
4
12 11
12 4
12 1
12 24

Output
18
12
3
24

Note
In the first testcase, you can split two chocolate bars into 3 pieces, three chocolate bars into 2 pieces and leave the rest as is.
Then, six friends can take a 100 gram piece and a 150 gram piece.
Other six friends can take a full bar of 300 grams. This way, the unfairness value is 300−(100+150)=50.
You can show that it's the smallest possible value for this testcase.
The total number of pieces is 18: 6 pieces of 100 grams, 6 pieces of 150 grams and 6 full bars of 300 grams.
In the second testcase, each chocolate bar can be split into 3 pieces, and each friend can take one such piece.
The unfairness value is 0. The number of pieces is 4⋅3=12.*/
public class JChocolateFairness {
}
