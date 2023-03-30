package org.helloworld.task.cop;
/*C. Team Building
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

Emma is a primary school teacher. There are 𝑛 children in her class. She is going to teach children teamwork.
To do this, she is going to divide the entire class into several teams and give each team a task.
In each team, there should be exactly one captain.
Each team must have at least 𝑙 (otherwise the team may not be able to complete the task) and
at most 𝑟 (otherwise the team is too hard to manage) children (including the captain).
Emma knows all the kids in her class. Some of them can only be team captains.
Others, on the contrary, cannot be captains. There are also those who do not care about their role in the team.
Your task is to determine if it is possible to divide all children into several teams.

Input
The first line contains a single integer 𝑡 (1≤𝑡≤1000) — the number of test cases.
The first line of each test case contains three integers 𝑛, 𝑙 and 𝑟 (1≤𝑛≤100; 1≤𝑙≤𝑟≤𝑛).
The second line contains a string 𝑠 of length 𝑛, consisting of characters 1, 2 and/or 3.
In this string, 1 represents a child which can only be a captain, 2 represents a child which cannot be team captain, and 3 represents a child which can handle any of the two roles.
Output
For each test case, print YES if it is possible to divide all children into several teams; otherwise print NO.
You may print each letter in any case (YES, yes, Yes will all be recognized as positive answer, NO, no and nO will all be recognized as negative answer).
Example
Input

6
3 1 2
123
5 3 5
31231
4 1 3
2122
6 2 4
332121
3 2 2
123
2 1 2
22

Output

YES
NO
NO
YES
NO
NO

Note

In the first example, one of the possible divisions is the following: the first team consists of the 1-st (plays the role of captain)
and the 2-nd child; the second team consists only of the 3-rd child (plays the role of captain).
In the second example, there should be at least two teams, because there are two children who can only be captains.
For two teams, at least 6 people are needed, because 𝑙 is equal to 3. Therefore, there is no answer for this example.
In the third example, there is 1 child who can only be a captain and 3 children who cannot be captains,
so the only possible division is one team with 4 children, but 𝑟 is equal to 3. Therefore, there is no answer for this example.
In the fourth example, one of the possible divisions is the following: the first team consists of the 2-nd (plays the role of captain)
and the 3-rd child; the second team consists of the 4-th (plays the role of captain) and the 5-th child;
 the third team consists of the 1-st and the 6-th (plays the role of captain) child.
In the fifth example, there is no way to divide 3 children into teams of 2 people each.
In the sixth example, there are no children who can become team captain, so it is impossible to create even a single team.

*/


import java.util.Scanner;

public class CTeamBuilding {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCasesNum = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCasesNum; i++) {
            String[] input = stdin.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int min = Integer.parseInt(input[1]);
            int max = Integer.parseInt(input[2]);
            String[] childrenst = stdin.nextLine().split(" ");
            int cap = 0;
            int notcap = 0;
            int smth = 0;
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(childrenst[j]);
                if (num == 1) {
                    cap++;
                } else if (num == 2) {
                    notcap++;
                } else if (num == 3) {
                    smth++;
                }
            }
            isTeam(n, cap, notcap, smth,max,min);
        }
    }

    public static boolean isTeam(int n, int cap, int notCap, int smth,int max,int min) {
        if(n/min<cap){
            return false;
        }
        if(cap+notCap+smth)
    }
}
