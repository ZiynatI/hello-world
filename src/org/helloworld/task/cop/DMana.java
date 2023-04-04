package org.helloworld.task.cop;
/*D. Mana
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

Alice plays a computer game. Her character is a mage; right now, she is trying to defeat a fearsome monster.
Unfortunately, as Alice has found out, the monster is completely immune to almost all of her spells, except one,
which costs exactly 𝑛 mana to cast. Alice has time to cast this spell only once; and in order to kill the monster with this spell,
she has to have exactly 𝑛 mana before casting the spell, since it is amplified if the caster spends all of their mana on it.
Initially, Alice's character has 1 mana. She has got magic potions of two types, which increase her mana points:
   if the character has 𝑥 mana and drinks a potion of type 1, her mana becomes equal to 2𝑥−1;
   if the character has 𝑥 mana and drinks a potion of type 2, her mana becomes equal to 2𝑥+1.
You may assume that Alice's character has infinitely many potions of both types. They can be drunk in any order.
 For example, if Alice's character drinks a potion of type 2, then a potion of type 2 again, then a potion of type 1,
 and then a potion of type 1 again, her mana becomes equal to 25.
Unfortunately, Alice cannot figure how to get her mana to exactly 𝑛.
You have to help her by telling her how to get to exactly 𝑛mana by drinking the minimum number of potions.

Input
The first line contains a single integer 𝑡 (1≤𝑡≤1000) — the number of test cases.
The only line of each test case contains a single integer 𝑛 (2≤𝑛≤10^18).
Additional constraint on the input: in each test case, it is possible to get exactly 𝑛 mana.

Output
For each test case, print a single string 𝑠, consisting of characters 1 and/or 2 — the sequence of types of potions of the minimum length
that allows to get exactly 𝑛 mana, starting with 1mana. Character 1 represents drinking a potion of the first type,
2 represents drinking a potion of the second type.
If there are multiple answers, print any of them.

Example
Input
5
5
25
69
1337
576460752303423487

Output
21
2211
211121
2121122211
2222222222222222222222222222222222222222222222222222222222
*/
public class DMana {
}
