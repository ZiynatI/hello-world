package org.helloworld.task.cop.practtice;
//A. Next Sunday
//time limit per test
//2 seconds
//memory limit per test
//512 megabytes
//input
//standard input
//output
//standard output
//The year 2023 consists of 365
//days. The first day of this year is Sunday, and the last day of this year is Sunday as well.
//Every Sunday, Emma goes to a local pizzeria with her friends. She really enjoys these opportunities to hang out and socialize, and during every day which is not Sunday, she spends at least several minutes thinking how many days are left until her next meetup with friends.
//Emma wants a program which can tell her the number of days until the next Sunday. Of course, she can count these days herself, but using a program is more efficient and simple, right?
//You have to develop a program which, given 𝑛
//— the index of the day in the year 2023 — returns the number of days until the next Sunday (including the day 𝑛
//itself).
//Input
//The only line of the input contains one integer 𝑛
//(2≤𝑛≤364
//) — the index of the day of the year 2023.
//Additional constraint on the input: the 𝑛
//-th day of the year 2023 is not Sunday.
//Output
//Print one integer — the number of days from the 𝑛
//-th day until the next Sunday (including the 𝑛
//-th day).
//Examples
//Input
//32
//Output
//4
//Input
//77
//Output
//1
//Note
//In the first example, the 32
//-th day of the year is the 1st of February, which is Wednesday. Next Sunday is the 5th of February (the 36-th day of the year), so there are 4
//days until it.
//In the second example, the 77
//-th day of the year is the 18th of March, which is Saturday. The next day is Sunday, so the number of days left until Sunday, if we include the current day, is 1
//.

import java.util.Scanner;

public class ANextSunday {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int input = stdin.nextInt();
        int result = 7 - (input - 1) % 7;
        System.out.println(result);
    }
}
