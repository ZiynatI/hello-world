package org.helloworld.task.cop.practice;
/*L. Japanese Chocolate
time limit per test
4 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

Monocarp-san works at a Japanese chocolate factory. He was assigned a task to design a new chocolate bar.
Monocarp-san came up with the following idea.
Let the bar be a rectangle 𝑛×𝑚 such that each piece contains a lowercase Latin letter on it.
Monocarp-san wants to make such a bar that it spells the name of the factory, which is the string 𝑡.
Since the factory is Japanese, the text is read column by column from right to left from top to bottom.
Let the concatenation of all columns spell some string 𝑠 of length 𝑛⋅𝑚.
The design of the chocolate bar is nice if 𝑡 appears in 𝑠 as a contiguous substring.
Monocarp-san decided to build a nice chocolate bar row by row.
He prepared 𝑘 options for a row of pieces — 𝑘 strings, consisting of 𝑚 lowercase Latin letters.
Now he wants to assemble a nice chocolate bar from these rows.
In particular, he wants to choose the number of rows 𝑛 and a sequence 𝑐1,𝑐2,…,𝑐𝑛, where 𝑐𝑖 is the index of option for the 𝑖-th row.
Each option can be used multiple times. Additionally, Monocarp-san wants the bar to be compact — to contain as little rows as possible.
Turns out, it's not an easy task. Thus, he asks for your help.
Can you help Monocarp-san to determine the smallest number of rows a nice chocolate bar can consist of, and what can these rows be?
If there are multiple answers with the smallest number of rows, you can output any of them. If there is no answer, print -1.
Input
The first line contains two integers 𝑘 and 𝑚 (1≤𝑘,𝑚≤100) — the number of options for a row and the number of columns in the bar, respectively.
The 𝑖 -th of the next 𝑘 lines contains a string 𝑎𝑖 (|𝑎𝑖|=𝑚) — the 𝑖-th option for a row. All options are different.
The last line contains a string 𝑡 (1≤|𝑡|≤200), consisting of lowercase Latin letters.
Output
If there is no answer, the only line should contain -1.
Otherwise, the first line should contain the number of rows 𝑛. The second line should contain the sequence 𝑐1,𝑐2,…,𝑐𝑛 (1≤𝑐𝑖≤𝑘).
The chocolate bar assembled with these row options should be nice. 𝑛 should be the smallest possible.

If there are multiple answers with the smallest number of rows, you can output any of them.
Examples
Input

9 7
wopytrt
mgfceio
opqwrdv
dflkjhg
jhjsoof
qoerqee
lkjklll
qweqeep
mnbefcx
codeforces

Output

4
2 9 5 3

Input

3 4
dpcz
ztcz
zeea
accepted

Output

3
1 2 3

Input

1 4
oooo
ooooooooooo

Output

3
1 1 1

Input

2 3
waw
awa
ac

Output

-1
*/
public class LJapaneseChocolate {
}
