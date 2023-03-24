package org.helloworld.task.cop.practtice;
//time limit per test
//2 seconds
//memory limit per test
//256 megabytes
//input
//standard input
//output
//standard output
//
//You help to organize an onsite programming contest, and you are responsible for the mice the participants will use. You have 𝑚
//wireless mice and 𝑛 batteries (𝑚≤𝑛). The 𝑖-th battery contains 𝑎𝑖
//
//units of energy.
//
//All mice are the same, and you can install either one or two batteries in any mouse. If the total energy of batteries you installed in some mouse is equal to 𝑡
//then this mouse will work for 𝑡 minutes (𝑡=𝑎𝑖 if you installed the 𝑖-th battery or 𝑡=𝑎𝑖+𝑎𝑗 if you installed two batteries 𝑖 and 𝑗
//
//).
//
//Your goal is to prepare all 𝑚
//
//mice to the contest. You are prohibited from replacing batteries in the middle of the contest since it may create unfairness. Calculate the maximum possible length of the contest (in minutes) you can set if you need to ensure that all mice work during the whole contest.
//
//You can assume that batteries will be installed simultaneously immediately at the start of the contest.
//Input
//
//Each test contains multiple test cases. The first line contains the number of test cases 𝑡
//(1≤𝑡≤104
//
//). The description of the test cases follows.
//
//The first line of each test case contains two integers 𝑛
//and 𝑚 (1≤𝑚≤𝑛≤2⋅105
//
//) — the number of batteries and mice.
//
//The second line of each test case contains 𝑛
//integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤106) — the capacity of the 𝑖
//
//-th battery.
//
//The sum of 𝑛
//over all test cases does not exceed 2⋅105
//
//.
//Output
//
//For each test case, print the single integer — the maximum possible length of the contest if all 𝑚
//
//mice should work during the whole contest.
//Example
//Input
//Copy
//
//4
//1 1
//1
//2 1
//1000000 1000000
//4 3
//10 4 6 12
//7 2
//8 3 8 3 5 1 8
//
//Output
//Copy
//
//1
//2000000
//10
//13
//
//Note
//
//In the first test case, all you can do is to install the first battery in the only mouse. That mouse will work 1
//minute, so the maximum possible length of the contest is 1
//
//minute.
//
//In the second test case, you can install both batteries in the only mouse to get the working time equal to 1000000+1000000=2000000
//
//minutes.
//
//In the third test case, you can install the 1
//-st battery in the first mouse (working time is equal to 10), the 2-nd and the 3-rd batteries in the second mouse (working time is 4+6=10), and the 4-th battery in the third mouse (working time is 12). The maximum length of the contest will be equal to 10, since the second mouse will work only 10
//
//minutes.
public class IMiceandBatteries {
}
