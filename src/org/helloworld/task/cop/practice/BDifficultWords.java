package org.helloworld.task.cop.practice;
/*B. Difficult Words
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

In the English language, the letters a, e, o, i, u and y are vowels, the rest are consonants.
Note that y can be a consonant, but in this problem, we assume that it is always a vowel.
Let's call a string of letters difficult to pronounce if it contains four or more consonants in a row.
Otherwise, the string is easy to pronounce.
For example, strings constructor and strength are difficult, but practice and codeforces are easy.
You are given a string 𝑠 consisting of lowercase Latin letters. Determine if it is difficult or easy to pronounce.
Input
The first line contains a single integer 𝑡 (1≤𝑡≤1000) — the number of test cases.
The only line of each test case contains a string 𝑠
(1≤|𝑠|≤100), consisting of lowercase Latin letters.
Output
For each test case, print Difficult, if the given string is difficult to pronounce, otherwise print Easy.
Example
Input
4
constructor
practice
codeforces
strength

Output
Difficult
Easy
Easy
Difficult

*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BDifficultWords {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int n = stdin.nextInt();
        while (n > 0) {
            isEasyOrDifficult(stdin);
            n--;
        }
    }

    public static void isEasyOrDifficult(Scanner stdin) {
        String s = stdin.next();
        String r = "Easy";
        List<Character> list = new ArrayList<>(Arrays.asList('a', 'e', 'o', 'i', 'u', 'y'));
        int consonantInRow = 0;
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                consonantInRow = 0;
            } else {
                consonantInRow++;
            }
            if (consonantInRow == 4) {
                r = "Difficult";
                break;
            }
        }
        System.out.println(r);
    }

}
