package org.helloworld.task.cop;
/*L. Chemical Lab
time limit per test
5 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

Anya works in a chemical laboratory. For each experiment, a certain specific amount of some substance is required.
In order to measure the exact amount, Anya uses balance scales. On the left side of the scales, she puts metal plates,
the total weight of which should be equal to the required weight of substance.
Then she puts the exact amount of the substance she needs in such a way that the scales are balanced.
Anya puts the plates on the left bowl of the scale on top of each other in a stack, but she can never put
a plate with greater weight on top of a plate with smaller weight. Initially, there are no plates on the left side of the scale.
In one move, Anya can either put one plate on top of the left bowl, or remove the top plate from the left bowl.
For example, if there are plates with weights [5,3] on top of the left bowl, and Anya has plates with weights 5, 4, 3 and 1, then in one move Anya can get [5,3,3], [5,3,1], or [5] on the left side of the scale.
Anya has 𝑛 types of plates, the weight of one plate of the 𝑖-th type is 𝑎𝑖grams. You can assume that Anya has an unlimited number of plates of each type.
Anya received a list of 𝑚 requests. According to the list, firstly Anya should measure 𝑟1 grams of the substance, then 𝑟2 grams of the substance, ..., 𝑟𝑛 grams of the substance. In order to measure 𝑥 grams of the substance, she has to put plates with total weight of exactly 𝑥 on the left side of the scale. Your task is to calculate the minimum number of moves in order to measure the required weight of substance to all requests in the order they are given, or report that it is impossible.
Input
The first line contains two integers 𝑛 and 𝑚 (1≤𝑛≤15; 1≤𝑚≤500) — the number of types of plates and the number of requests, respectively.
The second line contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎1<𝑎2<⋯<𝑎𝑛≤30).
The third line contains 𝑚 integer 𝑟1,𝑟2,…,𝑟𝑚 (1≤𝑟𝑖≤45).
Output
Print one integer — the minimum number of moves Anya has to make in order to measure the required weight of substance to all requests in the order they are given, or report that it is impossible.
Examples
Input
3 3
1 2 3
4 5 6

Output
4

Input

2 3
3 4
1 6 8

Output
-1

Input
5 10
2 3 5 6 8
3 15 2 15 14 5 15 11 8 9

Output
29*/
public class LChemicalLab {
}
