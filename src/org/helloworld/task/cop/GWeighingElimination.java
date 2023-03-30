package org.helloworld.task.cop;
/*G. Weighing Elimination
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output
There are 𝑛 weights: the first one weighs 1g, the second one weighs 2g and so on.
These weights are arranged in some order 𝑝1,𝑝2,…,𝑝𝑛, where 𝑝𝑖 is the weight of the 𝑖-th weight.
First, 𝑝1 is placed on one side of the scales. Then 𝑝2 is placed on the other side, and the lighter of the two weights is removed.
Then 𝑝3 is placed on the vacant side of the scales, and the lighter of the two weights currently on the scales is removed.
After 𝑝𝑛is placed, and the lighter one of the current pair is removed, the process stops.
For each 𝑖 from 1 to 𝑛, let 𝑐𝑖 be the number of weightings the weight 𝑖 has won. Let this sequence 𝑐1,𝑐2,…,𝑐𝑛 be called a characteristic array.
You are given an integer array of length 𝑛. Check if it can be a characteristic array of some order 𝑝1,𝑝2,…,𝑝𝑛 and restore this order if so.
If there are multiple answers, print any of them.

Input
The first line contains a single integer 𝑡(1≤𝑡≤1000) — the number of testcases.
The first line of each testcase contains a single integer 𝑛 (2≤𝑛≤100) — the number of weights.
The second line contains 𝑛 integers 𝑐1,𝑐2,…,𝑐𝑛 (0≤𝑐𝑖≤𝑛−1).

Output
The first line should contain "NO" if the given array 𝑐1,𝑐2,…,𝑐𝑛 can't be a characteristic array of any order of 𝑛 weights.
Otherwise, the first line should contain "YES". The second line should contain 𝑛 integers 𝑝1,𝑝2,…,𝑝𝑛 (1≤𝑝𝑖≤𝑛, all elements are distinct) —
the order of weights. If there are multiple answers, print any of them.
Example
Input
5
2
0 1
4
0 1 2 3
5
0 0 1 2 1
5
0 2 0 0 1
4
0 1 1 1

Output
YES
2 1
NO
YES
3 2 4 1 5
NO
YES
1 2 3 4
*/
public class GWeighingElimination {
}
