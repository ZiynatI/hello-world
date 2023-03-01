package org.helloworld.task;

import java.util.Arrays;

public class Laundry {
    public static void main(String[] args) {
        System.out.println(washingTime(new int[]{1, 2, 3}, 2));
    }

    public static int washingTime(int[] customers, int machinesNum) {
        int[] machines = new int[machinesNum];
        for (int customer : customers) {
            Arrays.sort(machines);
            machines[0] += customer;
        }
        Arrays.sort(machines);
        return machines[machinesNum - 1];
    }
}
