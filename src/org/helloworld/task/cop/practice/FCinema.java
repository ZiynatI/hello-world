package org.helloworld.task.cop.practice;

/*F. Cinema
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

A company of friends decided to go to the cinema.
The cinema auditorium has 𝑛 seats arranged in a row and numbered from 1 to 𝑛 from left to right.
Each seat is either occupied by one of the friends or free.
The friends decided that they want to sit next to each other (i.e. occupy consecutive seats).
In order to do this, some of the friends will move from their seats to other seats.
Note that each person may move to any seat, not necessarily an adjacent one.
Obviously, after the friends move, no seat should be occupied by more than one of them.
You are given a string 𝑠 of length 𝑛, consisting of characters 0 and/or 1.
The character 𝑠𝑖 is equal to 1 if the 𝑖-th seat is occupied by one of the friends, or 0 if the 𝑖-th seat is empty.
You have to calculate the minimum number of people who need to move so that all friends occupy consecutive seats.

Input
The first line contains a single integer 𝑡 (1≤𝑡≤1000) — the number of test cases.
The only line of each test case contains a string 𝑠 (1≤|𝑠|≤100), consisting of characters 0 and/or 1.

Output
For each test case, print one integer — the minimum number of people who need to move so that all friends occupy consecutive seats.
Example
Input

5
1010001
000
01100111001
1111
101010101

Output

1
0
2
0
2

Note

In the first example, you can move one person from 7-th seat to 2-nd seat, so the string becomes 1110000.
In the second example, there are no occupied seats, so the answer is 0.
In the third example, you can move one person from 2-nd seat to 5-th seat, so the string becomes 00101111001,
and then move one person from 11-th seat to 4-th seat, so the string becomes 00111111000.
In the fourth example, friends are already occupying consecutive seats.
In the fifth example, you can move one person from 1-st seat to 6-th seat, so the string becomes 001011101,
and then move one person from 3-rd seat to 8-th seat, so the string becomes 000011111.*/

import java.util.Scanner;

public class FCinema {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCases = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCases; i++) {
            char[] friends = stdin.nextLine().toCharArray();
            moveFriends(friends);
        }

    }

    public static void moveFriends(char[] chars) {
        int totalFriends = 0;
        for (char c : chars) {
            if (c == '1') {
                totalFriends++;
            }
        }
        if (totalFriends == 0 || totalFriends == chars.length) {
            System.out.println(0);
            return;
        }

        int friends = 0;
        for (int i = 0; i < totalFriends; i++) {
            friends += chars[i] == '1' ? 1 : 0;
        }
        int maxFriends = friends;
        for (int i = 1; i <= chars.length - totalFriends; i++) {
            if (chars[i - 1] == '1') {
                friends--;
            }
            if (chars[i + totalFriends - 1] == '1') {
                friends++;
            }
            maxFriends = Math.max(maxFriends, friends);
        }
        System.out.println(totalFriends - maxFriends);
    }
}
