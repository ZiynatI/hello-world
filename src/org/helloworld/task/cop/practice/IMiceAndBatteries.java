package org.helloworld.task.cop.practice;

/*I. Mice and Batteries
time limit per test
2 seconds
memory limit per test
256 megabytes
input
standard input
output
standard output

You help to organize an onsite programming contest, and you are responsible for the mice the participants will use.
You have 𝑚 wireless mice and 𝑛 batteries (𝑚≤𝑛). The 𝑖-th battery contains 𝑎𝑖 units of energy.
All mice are the same, and you can install either one or two batteries in any mouse.
If the total energy of batteries you installed in some mouse is equal to 𝑡 then this mouse will work for 𝑡 minutes (𝑡=𝑎𝑖 if you installed the 𝑖-th battery or 𝑡=𝑎𝑖+𝑎𝑗 if you installed two batteries 𝑖 and 𝑗).
Your goal is to prepare all 𝑚 mice to the contest.
You are prohibited from replacing batteries in the middle of the contest since it may create unfairness.
Calculate the maximum possible length of the contest (in minutes) you can set if you need to ensure that all mice work during the whole contest.
You can assume that batteries will be installed simultaneously immediately at the start of the contest.

Input
Each test contains multiple test cases. The first line contains the number of test cases 𝑡 (1≤𝑡≤104). The description of the test cases follows.
The first line of each test case contains two integers 𝑛 and 𝑚 (1≤𝑚≤𝑛≤2⋅105) — the number of batteries and mice.
The second line of each test case contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤106) — the capacity of the 𝑖-th battery.
The sum of 𝑛 over all test cases does not exceed 2⋅105.

Output
For each test case, print the single integer — the maximum possible length of the contest if all 𝑚 mice should work during the whole contest.
Example
Input

4
1 1
1
2 1
1000000 1000000
4 3
10 4 6 12
7 2
8 3 8 3 5 1 8

Output

1
2000000
10
13

Note

In the first test case, all you can do is to install the first battery in the only mouse.
That mouse will work 1minute, so the maximum possible length of the contest is 1minute.
In the second test case, you can install both batteries in the only mouse to get the working time equal to 1000000+1000000=2000000 minutes.
In the third test case, you can install the 1-st battery in the first mouse (working time is equal to 10),
the 2-nd and the 3-rd batteries in the second mouse (working time is 4+6=10), and the 4-th battery in the third mouse (working time is 12).
The maximum length of the contest will be equal to 10, since the second mouse will work only 10 minutes.*/

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class IMiceAndBatteries {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        int testCases = Integer.parseInt(stdin.nextLine());
        for (int i = 0; i < testCases; i++) {
            String[] miceBatteriesNum = stdin.nextLine().split(" ");
            int miceNum = Integer.parseInt(miceBatteriesNum[1]);
            int batteriesNum = Integer.parseInt(miceBatteriesNum[0]);
            String[] batteriesEnergyst = stdin.nextLine().split(" ");
            PriorityQueue<Integer> be = new PriorityQueue<Integer>(Comparator.reverseOrder());
            int[] batteriesEnergy = new int[batteriesNum];
            for (int j = 0; j < batteriesNum; j++) {
                be.add(Integer.parseInt(batteriesEnergyst[j]));
                batteriesEnergy[j] = Integer.parseInt(batteriesEnergyst[j]);
            }
            System.out.println(findMouseWithMinEnergy(miceNum, be));
        }
    }

    public static int findMouseWithMinEnergy(int miceNum, PriorityQueue<Integer> batteries) {
        PriorityQueue<Mouse> mouseInnstallingbatteries = new PriorityQueue<>(energyComparator);
        PriorityQueue<Mouse> withTTwoBatteries = new PriorityQueue<>(energyComparator);
        for (int i = 0; i < miceNum; i++) {
            mouseInnstallingbatteries.add(new Mouse());
        }
        int energy = 0;
        while (batteries.size() != 0 && mouseInnstallingbatteries.size() != 0) {
            Mouse mouse = mouseInnstallingbatteries.poll();
            if (energy == 0) {
                energy = batteries.poll();
            }
            if (mouse.setEnergy(energy)) {
                mouseInnstallingbatteries.add(mouse);
                energy = 0;
            } else {
                withTTwoBatteries.add(mouse);
            }
        }
        while (!mouseInnstallingbatteries.isEmpty()) {
            withTTwoBatteries.add(mouseInnstallingbatteries.poll());
        }
        return withTTwoBatteries.peek().getEnergy();
    }

    static class Mouse {
        private int batteries = 0;
        private int energy = 0;

        public boolean setEnergy(int e) {
            if (batteries == 2) {
                return false;
            } else {
                batteries++;
                energy += e;
                return true;
            }
        }

        public int getEnergy() {
            return energy;
        }
    }

    public static Comparator<Mouse> energyComparator = new Comparator<Mouse>() {
        @Override
        public int compare(Mouse o1, Mouse o2) {
            return o1.getEnergy() - o2.getEnergy();
        }
    };
}
