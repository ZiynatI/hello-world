package org.helloworld.task.cop;

/*A. Watermelon Strikes Back
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

What's better on a hot summer day than a juicy watermelon slice? Huh, what do you mean it's not even summer?..
Alice, Bob and Charlie got themselves a huge watermelon. They cut it into some slices. Alice got 𝑎slices,
Bob got 𝑏 slices and Charlie got 𝑐slices.
However, they decided that it isn't too fair that someone has more slices than another.
Thus, they are going to give slices to one another until everyone has the same amount.
In one move, one person can give a single watermelon slice to another person.
What's the smallest number of moves required for everyone to have the same amount of slices? If it's not possible at all, print −1.

Input
The first line contains a single integer 𝑡(1≤𝑡≤100) — the number of testcases.
The only line of each testcase contains three integers 𝑎,𝑏 and 𝑐 (1≤𝑎,𝑏,𝑐≤100) — the initial number of watermelon slices for Alice, Bob and Charlie, respectively.

Output
For each testcase, print the smallest number of moves required for everyone to have the same amount of slices.
If it's impossible for everyone to have the same amount of slices, print −1.
Example
Input
Copy

3
1 2 3
99 99 100
10 10 10

Output
Copy

1
-1
0

Note

In the first testcase, Charlie gives one slice to Alice. Now, everyone has 2 slices. Thus, one move is enough.
In the third testcase, everyone already has the same amount of slices. Thus, zero moves are required.*/

import java.util.*;

public class AWatermelonStrikesBack {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCasesNum = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCasesNum; i++) {
            String[] arrst = stdin.nextLine().split(" ");
            Integer[] arr = new Integer[arrst.length];
            for (int j = 0; j < arrst.length; j++) {
                arr[j] = Integer.parseInt(arrst[j]);
            }
            giveSlices(arr);
        }
    }

    public static void giveSlices(Integer[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int i : arr) {
            pq.add(i);
            sum += i;
        }
        if (sum % 3 != 0) {
            System.out.println(-1);
            return;
        }
        if (Objects.equals(arr[0], arr[1]) && Objects.equals(arr[1], arr[2])) {
            System.out.println(0);
            return;
        }
        int mid = sum / 3;
        int count = 0;
        while (!arr[0].equals(mid) || !arr[1].equals(mid) || !arr[2].equals(mid)) {
            count++;
            Arrays.sort(arr);
            arr[0] = arr[0] + 1;
            arr[2] = arr[2] - 1;
        }
        System.out.println(count);
    }
}
