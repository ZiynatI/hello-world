package org.helloworld.task.cop.practtice;

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
