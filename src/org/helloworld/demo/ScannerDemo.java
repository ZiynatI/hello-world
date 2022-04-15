package org.helloworld.demo;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int userInput = s.nextInt();
        System.out.println("User input: " + userInput);

    }
}
