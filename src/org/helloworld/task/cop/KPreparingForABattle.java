package org.helloworld.task.cop;
/*K. Preparing for a Battle
time limit per test
2.5 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

You are playing yet another game where you, in order to win a battle, are planning to hire 𝑛
mercenaries and divide them into at most 𝑘

groups.

The only problem is that each mercenary has a person he hates and would ask an extra fee if they end up in the same group. More formally, the 𝑖
-th mercenary hates the 𝑚𝑖-th mercenary and will ask 𝑐𝑖

extra money if they are in the same group.

Assign each mercenary to a group, numbered from 1
to 𝑘

, in such a way that the total extra fee you need to pay is the minimum possible.

You are allowed to leave some groups empty.
Input

Each test contains multiple test cases. The first line contains the number of test cases 𝑡
(1≤𝑡≤104

). The description of the test cases follows.

The first line of each test case contains two integers 𝑛
and 𝑘 (2≤𝑛≤2⋅105; 1≤𝑘≤𝑛

) — the number of mercenaries you'll hire and the maximum number of groups you can form.

The second line of each test case contains 𝑛
integers 𝑚1,𝑚2,…,𝑚𝑛 (1≤𝑚𝑖≤𝑛; 𝑚𝑖≠𝑖) where 𝑚𝑖 is the index of mercenary the 𝑖

-th mercenary hates.

The third line of each test case contains 𝑛
integers 𝑐1,𝑐2,…,𝑐𝑛 (1≤𝑐𝑖≤106) — the extra fee the 𝑖-th mercenary will ask if the 𝑖-th and 𝑚𝑖

-th mercenaries will end up in the same group.

The sum of 𝑛
over all test cases does not exceed 2⋅105

.
Output

For each test case, firstly print the minimum possible total extra fee you have to pay to mercenaries.

Next print 𝑛
integers 𝑔1,𝑔2,…,𝑔𝑛 (1≤𝑔𝑖≤𝑘) where 𝑔𝑖 is a group the 𝑖

-th mercenary will be assigned to.
Example
Input
Copy

5
5 1
2 1 1 5 3
10 13 31 70 1
2 2
2 1
100 100
6 2
2 3 1 6 4 5
10 2 5 1 2 3
4 4
2 1 4 3
100 100 100 100
4 3
2 1 1 2
1 1 1 1

Output
Copy

125
1 1 1 1 1
0
2 1
3
1 2 2 1 2 1
0
2 3 2 3
0
2 3 1 1
*/
public class KPreparingForABattle {
}
