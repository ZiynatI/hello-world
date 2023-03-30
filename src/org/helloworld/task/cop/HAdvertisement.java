package org.helloworld.task.cop;

/*H. Advertisement
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output
An advertising agency received an order to create a signboard with the name of the company.
To increase its influence on the audience, the agency is going to capitalize some letters of the company name.
Note that these are the only changes the agency can make — they cannot delete/insert/reorder letters,
they can only change some letters from lowercase to uppercase.
Marketing experts have proven that each letter a changed from lowercase to uppercase increases the influence on the audience by 1
point, each letter b changed from lowercase to uppercase increases the influence on the audience by 2 points,
and so on up to the letter z, which (when changed from lowercase to uppercase) increases the influence by 26.
The only restrictions that don't allow the agency to capitalize all letters of the name are the following ones:
    the name should not contain three or more consecutive uppercase letters;
    among any seven consecutive letters, no more than three letters can be uppercase.
You are given a string 𝑠 consisting of lowercase Latin letters — the company name.
Calculate the maximum possible influence of a signboard with the name 𝑠on it, considering that the aforementioned rules should not be broken.
Input
The first line contains a single integer 𝑡 (1≤𝑡≤104) — the number of test cases.
The only line of each test case contains a string 𝑠(1≤|𝑠|≤2⋅105), consisting of lowercase Latin letters.
The sum of lengths over all test cases doesn't exceed 2⋅105.
Output
For each test case, print one integer — the maximum possible influence of a signboard with the name 𝑠 on it, considering that
the aforementioned rules should not be broken.
Example
Input
5
mm
abcca
constructor
contest
codeforces

Output
26
7
93
59
67

Note
In the first example, one of the possible answers is MM with the influence 𝑀+𝑀=13+13=26.
In the second example, one of the possible answers is AbCCa with the influence 𝐴+𝐶+𝐶=1+3+3=7.
In the third example, one of the possible answers is cOnStrUcToR with the influence 𝑂+𝑆+𝑈+𝑇+𝑅=15+19+21+20+18=93.
In the fourth example, one of the possible answers is conTeST with the influence 𝑇+𝑆+𝑇=20+19+20=59.
In the fifth example, one of the possible answers is cOdefORceS with the influence 𝑂+𝑂+𝑅+𝑆=15+15+18+19=67.*/
public class HAdvertisement {

}
